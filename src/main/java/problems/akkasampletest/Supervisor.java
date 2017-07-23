package problems.akkasampletest;

import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;

import static akka.japi.pf.DeciderBuilder.match;

public class Supervisor extends AbstractLoggingActor {

    public static final String BEAN_NAME = "supervisor";

    public static Props props() {
        return Props.create(Supervisor.class);
    }

    private final SupervisorStrategy strategy = new OneForOneStrategy(false,
            match(InterruptedException.class, e ->
                    SupervisorStrategy.resume()
            ).match(Throwable.class, e ->
                    SupervisorStrategy.restart()
            ).build());


    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    @Override
    public Receive createReceive() {
        return new ReceiveBuilder()
                .match(Props.class, props -> {
                    sender().tell(context().actorOf(props), ActorRef.noSender());
                })
                .matchAny(msg -> log().error("Unknown message: {}", msg))
                .build();
    }
}
