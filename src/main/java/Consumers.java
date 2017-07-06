import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by jfreire on 06.07.17.
 */
public class Consumers {

    static Map map = new HashMap();

    static List list = new ArrayList();


    static {
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");
        map.put("5", "Five");
        map.put("6", "Six");
        map.put("7", "Seven");
        map.put("8", "Eight");
        map.put("9", "Nine");
        map.put("0", "Zero");

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

    }

    public static void main(String[] args) {
        BiConsumer func = (k, v) -> System.out.println("k " + k + ";v " + v);
        Consumer func2 = (k) -> System.out.println("k " + k);
        map.forEach(func);

        list.forEach(func2);
    }
}