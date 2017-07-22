package snippets.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jfreire on 04.07.17.
 */
public class StreamCollectorsTest {

   static double d = Stream.of("aa", "bb", "ccc", "ddd", "eee").collect(Collectors.averagingDouble(s -> s.length())).intValue();


    public static void main(String[] args) {

        System.out.println("d = " + d);
    }


}
