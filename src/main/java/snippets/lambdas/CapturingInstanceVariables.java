package snippets.lambdas;

import com.google.common.util.concurrent.MoreExecutors;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

/**
 * Created by jfreire on 06.07.17.
 */
public class CapturingInstanceVariables implements Runnable {

    //Instance variable captured by lambda
    private BigDecimal bd = new BigDecimal(1);

    @Override
    public void run() {
        Function<BigDecimal, BigDecimal> func = (a) -> bd.multiply(a);

        for (int j = 0; j < 999999999; j++) {
            func.apply(new BigDecimal(j));
        }
    }

    public static void main(String[] args) {

        Instant start = Instant.now();
        MoreExecutors.directExecutor().execute(new CapturingInstanceVariables());
        Instant end = Instant.now();

        System.out.println("Duration.between(start,end) = " + Duration.between(start, end));

    }
}


