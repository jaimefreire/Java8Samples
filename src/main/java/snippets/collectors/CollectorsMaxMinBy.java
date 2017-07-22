package snippets.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jfreire on 06.07.17.
 */
public class CollectorsMaxMinBy {


    //    static IntStream givenList = IntStream.rangeClosed(1,50000);
    static IntStream givenList = IntStream.empty();

    public static void main(String[] args) {

        Optional<Integer> result = givenList.boxed()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));

        System.out.println("result = " + result.orElse(-1));
    }
}
