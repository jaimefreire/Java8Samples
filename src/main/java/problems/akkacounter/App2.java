package problems.akkacounter;

import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import scala.Console;

/**
 * Created by jfreire on 23.07.17.
 */
public class App2 {

    static class Alarm extends AbstractLoggingActor {

        private final String password;

        private final Receive enabled;
        private final Receive disabled;

        public Alarm(String password) {
            this.password = password;

            //Configures what actions can take place in each state
            enabled = new ReceiveBuilder().match(Activity.class, this::onActivity)
                    .match(Disable.class, this::onDisable)
                    .build();

            disabled = new ReceiveBuilder().match(Enable.class, this::onEnable)
                    .build();
        }

        //Three methods that handle events
        private void onActivity(Activity activity) {
            log().info("Alarm!");
        }

        private void onDisable(Disable disable) {
            if (password.equals(disable.pass)) {
                log().info("Alarm disabled");
                getContext().become(disabled);
            }
        }

        private void onEnable(Enable enable) {
            if (password.equals(enable.pass)) {
                log().info("Alarm enabled");
                getContext().become(enabled);
            } else {
                log().error("Wrong try to enable");
            }
        }

        @Override
        //Initial state
        public Receive createReceive() {
            return disabled;

        }

        //Protocol
        static class Activity {
        }

        static class Disable {
            private final String pass;

            public Disable(String pass) {
                this.pass = pass;
            }
        }

        static class Enable {
            private final String pass;

            public Enable(String pass) {
                this.pass = pass;
            }
        }

        //Basic class
        public static Props props(String password) {
            return Props.create(Alarm.class, password);
        }
    }

    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create();
        final ActorRef alarm = system.actorOf(Alarm.props("cat"), "alarm");

        alarm.tell(new Alarm.Activity(), ActorRef.noSender());
        alarm.tell(new Alarm.Enable("no"), ActorRef.noSender());
        alarm.tell(new Alarm.Enable("cat"), ActorRef.noSender());
        alarm.tell(new Alarm.Activity(), ActorRef.noSender());
        alarm.tell(new Alarm.Disable("bad"), ActorRef.noSender());
        alarm.tell(new Alarm.Disable("cat"), ActorRef.noSender());
        alarm.tell(new Alarm.Activity(), ActorRef.noSender());

        System.out.println("Press enter to exit");

        Console.readLine();
        system.terminate();
    }
}
