package snippets.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by jfreire on 07.07.17.
 */
public class FindAnyStream {

    public static void main(String[] args) {

        List<String> sts = new ArrayList();
        sts.add("1");
        sts.add("2");
        sts.add("3");
        sts.add("4");

        System.out.println(sts.stream().findAny().orElse("Mier"));
        System.out.println(sts.parallelStream().findFirst().orElse("Mier"));

    }
}
