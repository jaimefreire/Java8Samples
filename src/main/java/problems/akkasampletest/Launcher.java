package problems.akkasampletest;

import akka.actor.ActorRef;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

/**
 * Created by jfreire on 22.07.17.
 */
public class Launcher {
    private ActorRef happyBdayActorRef;

    @Inject
    public Launcher(@Named(AppActor.BEAN_NAME) ActorRef happyBdayActorRef) {
        this.happyBdayActorRef = happyBdayActorRef;
    }

    public ActorRef getHappyBdayActorRef() {
        return happyBdayActorRef;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Config());
        Launcher app = injector.getInstance(Launcher.class);
        app.getHappyBdayActorRef().tell("Hello", ActorRef.noSender());
    }
}

