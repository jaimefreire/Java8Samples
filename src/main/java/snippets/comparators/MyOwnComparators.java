package snippets.comparators;

import java.util.*;
import static java.lang.System.out;

/**
 * Created by jfreire on 04.07.17.
 */
public class MyOwnComparators {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});

        Comparator<Integer> c1 = Comparator.comparing(e -> e.intValue() * -1);
        Comparator<Integer> c2 = Comparator.comparing(Integer::intValue);


        Collections.sort(list,c1);
        out.println(list);
        Collections.sort(list,c2);
        out.println(list);

    }
}
