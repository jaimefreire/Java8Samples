package snippets.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * Created by jfreire on 06.07.17.
 */
public class MapMerge {

    static Map<String, String> map = new HashMap<>();

    static Map<String, String> map2 = new HashMap<>();

    static {
        map.put("a", "1");
        map.put("b", "2");

        map2.put("a", "");
        map2.put("b", "22");
        map2.put("c", "3");
        map2.put("d", "4");

    }

    public static void main(String[] args) {

        BiFunction<String, String, String> func = (k, v) -> v;
        BiConsumer<String, String> cons = (k, v) -> map.merge(k, v, func);

        map2.forEach(cons);

        System.out.println(map);

    }

}
