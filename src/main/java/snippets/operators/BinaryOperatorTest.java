package snippets.operators;

import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jfreire on 09.07.17.
 */
public class BinaryOperatorTest {



    public static void main(String[] args) {

        Stream<Integer> myStream = IntStream.of(1,10).boxed();

        BinaryOperator<Integer> bop = (Integer i, Integer j) -> i +j;

        BinaryOperator<Integer> bop2 = Integer::sum;

        System.out.println("BOP: " + bop.apply(1,2));

        System.out.println("BOP: " + bop2.apply(1,2));



    }
}
