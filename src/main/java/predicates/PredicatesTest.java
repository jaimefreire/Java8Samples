package predicates;

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


    }
}
