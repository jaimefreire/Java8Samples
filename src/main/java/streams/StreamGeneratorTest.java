package streams;

import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jfreire on 18.06.17.
 */
public class StreamGeneratorTest {

    public static void main(String[] args) {


        Supplier<UUID> randomUUIDSupplier = UUID::randomUUID;

        Stream<UUID> infiniteStreamOfRandomUUID = Stream.generate(randomUUIDSupplier);

        List<UUID> randomInts = infiniteStreamOfRandomUUID
                .skip(10)
                .limit(10)
                .collect(Collectors.toList());

        randomInts.forEach(System.out::println);
//        System.out.println(randomInts);
    }

}
