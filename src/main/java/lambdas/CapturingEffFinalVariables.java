package lambdas;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

/**
 * Created by jfreire on 06.07.17.
 */
public class CapturingEffFinalVariables {

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal(1);
        Function<BigDecimal, BigDecimal> func = (a) -> bd.multiply(a);

        Instant start = Instant.now();

        for (int j = 0; j < 999999999; j++) {
            func.apply(new BigDecimal(j));
        }
        Instant end = Instant.now();


        System.out.println("Duration.between(start,end) = " + Duration.between(start, end));

    }
}
