/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package problems.akkacounter;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import scala.Console;

/**
 * counter - actor that keeps state
 */
public class App1 {

    static class Counter extends AbstractLoggingActor {

        // protocol
        static class Message {
        }

        private int counter = 0;

        @Override
        public Receive createReceive() {
            return new ReceiveBuilder()
                    .match(Message.class, this::onMessage)
                    .build();
        }

        private void onMessage(Message message) {
            counter++;
            log().info("Increased counter " + counter);
        }

        public static Props props() {
            return Props.create(Counter.class);
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("sample1");

        final ActorRef actorCounter = system.actorOf(Counter.props(), "counter");

        for (int i = 0; i < 5; i++) {
            new Thread(() ->
            {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 50000; k++) {
                        actorCounter.tell(new Counter.Message(), ActorRef.noSender());
                    }
                }

            }).start();
        }

        System.out.println("ENTER to terminate");
        Console.readLine();
    }
}
