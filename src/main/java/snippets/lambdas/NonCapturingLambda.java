

package snippets.lambdas;

import com.google.common.util.concurrent.MoreExecutors;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;

/**
 * Created by jfreire on 06.07.17.
 */
public class NonCapturingLambda {

    public static void main(String[] args) {

        Function<BigDecimal, BigDecimal> func = (a) -> a.multiply(BigDecimal.TEN);

        Instant start = Instant.now();
        for (int j = 0; j < 999999999; j++) {
            func.apply(new BigDecimal(j));
        }
        Instant end = Instant.now();

        System.out.println("Duration.between(start,end) = " + Duration.between(start, end));

    }
}




