package collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jfreire on 05.07.17.
 */
public class PartitioningBy {

    public static void main(String[] args) {

        IntStream in = IntStream.rangeClosed(1,4);

        in.boxed().collect(Collectors.partitioningBy(n -> n%2==0 ));
    }
}
