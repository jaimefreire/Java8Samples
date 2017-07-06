package streams;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jfreire on 18.06.17.
 */
public class StreamsTest {

    public static void main(String[] args) {

        //magic(Stream.empty());
        magic(Stream.iterate(1, x -> x++));
    }

    private static void magic(Stream<Integer> s)
    {
        Optional o = s.filter(x -> x < 5).limit(3).max((x,y) -> x-y);
        System.out.println(o.get());
    }

}
