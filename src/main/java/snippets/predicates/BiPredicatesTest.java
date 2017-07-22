package snippets.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Created by jfreire on 19.07.17.
 */
public class BiPredicatesTest {

    public static void main(String[] args) {
        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);
        //
        System.out.println(b1.test("chicken", "chick"));
        System.out.println(b2.test("chicken", "chick"));

    }
}
