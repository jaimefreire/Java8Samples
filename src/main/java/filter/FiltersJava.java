package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by jfreire on 06.07.17.
 */
public class FiltersJava {

    static List numbers = new ArrayList();

    public static void main(String[] args) {

        numbers.add(1);
        numbers.add(7);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);


        Predicate<Integer> predit = p -> p > 4;
        //
        IntPredicate preditInt = p -> p > 4;


        //List after stream hasn't changed; it's immutable.
        numbers.stream().filter(predit).forEach(System.out::println);

        System.out.println(numbers);

    }
}
