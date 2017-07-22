package snippets.collectors;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jfreire on 18.07.17.
 */
public class ContrivedCollector {
    public static void main(String[] args) {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");

/*        Map<Integer, Optional<Character>> map = ohMy.collect(Collectors.groupingBy(
                z -> z.length(),
                Collectors.mapping(s -> s.charAt(0),
                        Collectors.minBy(Comparator.naturalOrder()))));
        System.out.println("map = " + map);
        */
    }
}
