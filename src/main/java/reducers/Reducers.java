package reducers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jfreire on 09.07.17.
 */
public class Reducers {

    static IntStream intStream = IntStream.range(1,123123123);
    static IntStream intStream2 = IntStream.range(1,123123123);

    public static void main(String[] args) {

        System.out.println(intStream.reduce(0, (i,j) -> (i+j)));

        System.out.println(intStream2.sum());

    }
}
