package collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jfreire on 05.07.17.
 */
public class AveragingInt {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("12", "13", "3", "1");

        double avg = stream.collect(Collectors.averagingInt(s -> Integer.parseInt(s)));

        System.out.println("avg = " + avg);
    }
}
