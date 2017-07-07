package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by jfreire on 07.07.17.
 */
public class IntStreamSum {

    public static void main(String[] args) {

        List<String> sts = new ArrayList();
        sts.add("1");
        sts.add("2");
        sts.add("3");
        sts.add("4");

        IntStream stream = sts.stream().flatMapToInt(s -> IntStream.of(Integer.parseInt(s)));

        IntStream stream2 = sts.stream().map(s -> Integer.parseInt(s));


        System.out.println(stream.sum());

    }
}
