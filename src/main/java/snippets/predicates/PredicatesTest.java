package snippets.predicates;

import java.util.function.Predicate;

/**
 * Created by jfreire on 09.07.17.
 */
public class PredicatesTest {

    public static void main(String[] args) {
        String in = "Abcd";
        Predicate<String> p = s -> s.indexOf("A") > 0;

        //Definir el predicado . Sólo se aplica al invocar test
        //System.out.println(p.and(s -> s.length() > 4).negate());//.test(in));

        System.out.println(p.and(s -> s.length() > 4).negate().test(in));
        System.out.println(p.negate().or(s -> s.length() > 4).test(in));

        //Working with default methods in Predicate Interface so
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        //Suboptimal
        Predicate<String> brownEggs = s -> s.contains("egg") && s.contains("brown");
        Predicate<String> otherEggs = s -> s.contains("egg") && !s.contains("brown");

        //Optimized with helpful default methods.
        Predicate<String> brownEggsOptim = egg.and(brown);
        Predicate<String> otherEggsOptim = egg.and(brown.negate());


    }
}
