package streams;

import java.util.LongSummaryStatistics;
import java.util.stream.LongStream;

/**
 * Created by jfreire on 04.07.17.
 */
public class LongStreamTest {

    public static void main(String[] args) {
        LongStream in = LongStream.of(3, 8, 4, 1, 0, 7, 2).sorted();


        LongSummaryStatistics sm = in.skip(2).limit(4).peek(System.out::println).summaryStatistics();

        System.out.println("sm.getCount() = " + sm.getCount());
        sm.accept(sm.getCount());
        System.out.println(sm.getCount());

        System.out.println(sm.getSum());
    }
}
