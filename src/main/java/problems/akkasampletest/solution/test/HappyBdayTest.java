package problems.akkasampletest.solution.test;

import akka.testkit.JavaTestKit;
import akka.testkit.TestActorRef;
import akka.testkit.TestProbe;
import problems.akkasampletest.solution.service.MessageHandlerService;
import problems.akkasampletest.solution.actors.HappyBdayActor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertThat;

public class HappyBdayTest {

    private static ActorSystem system;
    private static MessageHandlerService messageHandlerService;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
        messageHandlerService = mock(MessageHandlerService.class);
    }

    @AfterClass
    public static void teardown() {
        JavaTestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void testProps() {
        final JavaTestKit probe = new JavaTestKit(system);
        Props props = HappyBdayActor.props(messageHandlerService);
        assertThat(props.actorClass(), is(equalTo(HappyBdayActor.class)));
    }

    @Test
    public void testEventLoggerActorFirebaseRequestMatch() {

        TestProbe probe = TestProbe.apply(system);

        final Props props = HappyBdayActor.props(messageHandlerService);


        when(messageHandlerService.substr("RahulKumar",5))
                .thenReturn(String.valueOf("Kumar"));

        final TestActorRef<HappyBdayActor> pageCountActorTestActorRef = TestActorRef.create(system, props);
        pageCountActorTestActorRef.tell("RahulKumar", pageCountActorTestActorRef);

        probe.expectNoMsg();

    }
}
