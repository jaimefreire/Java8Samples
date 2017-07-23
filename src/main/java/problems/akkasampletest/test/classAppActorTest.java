package problems.akkasampletest.test;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import akka.testkit.TestActorRef;
import akka.testkit.TestProbe;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import problems.akkasampletest.AppActor;
import problems.akkasampletest.service.MessageHandlerService;

import static org.mockito.Mockito.when;

public class classAppActorTest {

    private static ActorSystem system;
    private static MessageHandlerService messageHandlerService;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
        messageHandlerService = new MessageHandlerService(); //mock(MessageHandlerService.class);
    }

    @AfterClass
    public static void teardown() {
        JavaTestKit.shutdownActorSystem(system);
        system = null;
    }


    @Test
    public void testProps() {

        final JavaTestKit probe = new JavaTestKit(system);
        Props props = AppActor.props(messageHandlerService);
        //assertThat(props.actorClass(), is(equalTo(AppActor.class)));
    }


    @Test
    public void testEventLoggerActorFirebaseRequestMatch() {
        TestProbe probe = TestProbe.apply(system);

        final Props props = AppActor.props(messageHandlerService);
        when(messageHandlerService.substr("RahulKumar", 5))
                .thenReturn(String.valueOf("Kumar"));
        final TestActorRef<AppActor> happyBdayActorTestActorRef = TestActorRef.create(system, props);
        happyBdayActorTestActorRef.tell("RahulKumar", happyBdayActorTestActorRef);
        probe.expectNoMsg();
    }
}