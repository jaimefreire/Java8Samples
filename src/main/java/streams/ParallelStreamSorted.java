package streams;

import java.util.stream.Stream;

/**
 * Created by jfreire on 09.07.17.
 */
public class ParallelStreamSorted {

    public static void main(String[] args) {

        Stream sts1 = Stream.of("A", "B");
        Stream sts2 = Stream.of("1","2");

//        Stream out = Stream.concat(sts1, sts2).parallel().sorted();


        //out.forEach(System.out::print);
    }
}
