package problems.akkasampletest;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.util.Timeout;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import problems.akkasampletest.service.MessageHandlerService;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import static akka.pattern.PatternsCS.ask;


/**
 * Created by jfreire on 22.07.17.
 */
public class Config extends AbstractModule {
    @Override
    protected final void configure() {
        bind(ActorSystem.class).toInstance(ActorSystem.apply());
        bind(MessageHandlerService.class).annotatedWith(Names.named(MessageHandlerService.BEAN_NAME)).
                to(MessageHandlerService.class);
    }

    @Singleton
    @Provides
    @Named(value = Supervisor.BEAN_NAME)
    public final ActorRef supervisorRef(final ActorSystem system) {
        return system.actorOf(Supervisor.props());
    }


    @Provides
    @Inject
    @Named(value = AppActor.BEAN_NAME)
    public final ActorRef HappyBdayActorRef(@Named(Supervisor.BEAN_NAME) final ActorRef supervisor,
                                            @Named(MessageHandlerService.BEAN_NAME) final MessageHandlerService messageHandlerService) throws Exception {
        CompletionStage<Object> eventFuture = ask(supervisor, AppActor.props(messageHandlerService),
                Timeout.apply(50, TimeUnit.MILLISECONDS));
        return (ActorRef) eventFuture.toCompletableFuture().get(60, TimeUnit.MILLISECONDS);
    }
}

