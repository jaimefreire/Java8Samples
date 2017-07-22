package snippets.optional;

import java.time.ZoneId;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * Created by jfreire on 05.07.17.
 */
public class OptionalTests {

    public static void main(String[] args) {
        Optional<Integer> op = Optional.of(12);

        op.ifPresent(myShiet());


        op.ifPresent((x) -> System.out.println(x.doubleValue()));


        op.orElse(2);

        op.isPresent();

        op.get();
    }

    static Consumer<Integer> myShiet() {
        Consumer<Integer> c = (x) -> System.out.println(x.doubleValue());
        return c;
    }


}
