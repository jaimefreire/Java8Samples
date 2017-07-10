package streams.clients;

import java.util.stream.Stream;

/**
 * Created by jfreire on 09.07.17.
 */
public class ParallelStreamTest {

    static Stream<String> stream = Stream.of("2","3", "aaa", "dfsdf");

    public static void main(String[] args) {

        System.out.println("args = " + stream.parallel().count());
    }
}
