package functions;

import com.google.common.collect.ImmutableList;
import sun.tools.jstat.Operator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by jfreire on 06.07.17.
 */
public class Functions {

    public static void main(String[] args) {

        UnaryOperator<Double> eq = (in) -> Math.sqrt(in);

        DoubleBinaryOperator op = (a, b) -> Double.valueOf(a) - Double.valueOf(b);

        //Type is 1, number of args 2
        BinaryOperator<Double> op2 = (a, b) -> Double.valueOf(a) - Double.valueOf(b);

//        Consumer<Double> cons = c -> op2 > 0;

        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        givenList.stream().collect(Collectors.toList());

        DoubleStream.of(5.33,2.34,5.32,2.31,3.51).boxed().collect(Collectors.toList());

        DoubleStream.of(5.33,2.34,5.32,2.31,3.51).boxed().collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));


        Map<String, Integer> result = givenList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        IntStream.rangeClosed(1,30000).forEach(System.out::println);
    }
}
