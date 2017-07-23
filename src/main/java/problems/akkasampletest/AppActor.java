package problems.akkasampletest;

import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import problems.akkasampletest.service.MessageHandlerService;

/**
 * Created by jfreire on 22.07.17.
 */
public class AppActor extends AbstractLoggingActor {


    public static final String BEAN_NAME = "AppActor";
    private final MessageHandlerService messageHandlerService;

    AppActor(MessageHandlerService messageHandlerServie) {
        this.messageHandlerService = messageHandlerServie;
    }

    public static Props props(MessageHandlerService messageHandlerService) {
        return Props.create(AppActor.class, messageHandlerService);
    }


    public static Props props() {
        return Props.create(AppActor.class);
    }

    @Override
    public Receive createReceive() {
        //responsiblity of this actor can be here
        return ReceiveBuilder.create()
                .match(String.class, message -> {
                    log().info("Message received from someone : {}" + message);
                })
                .matchAny(message -> log().error("Some unknown things happened : {}", message))
                .build();


    }

}
