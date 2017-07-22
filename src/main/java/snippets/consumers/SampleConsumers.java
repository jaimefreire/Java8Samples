package snippets.consumers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by jfreire on 19.07.17.
 */
public class SampleConsumers {

    public static void main(String[] args) {

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Annie");
        c2.accept("Annie");

        Map<String, Integer> map = new HashMap<>();

        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        //BiConsumer<String, Integer> b3 = Map::put;


        b1.accept("chicken", 7);
        b2.accept("chick", 1);

        System.out.println(map);
    }
}
