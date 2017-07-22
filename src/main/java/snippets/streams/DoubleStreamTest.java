package snippets.streams;

import java.time.ZoneId;
import java.util.stream.DoubleStream;

/**
 * Created by jfreire on 05.07.17.
 */
public class DoubleStreamTest {

    public static void main(String[] args) {

        DoubleStream d = DoubleStream.of(1.0,2.3,2);

        d.boxed().filter(s -> s-s.intValue()==0).forEach(System.out::print);

    }
}
