package lambdas;

import java.util.function.Consumer;

/**
 * Created by jfreire on 06.07.17.
 */
public class CapturingLambdas {


    public static void main(String[] args) {
        Consumer<String> lambdaCap = s -> System.out.println(s);
        lambdaCap.accept("Defined as a lambda");

        Consumer<String> methodRefCap = System.out::println;
        methodRefCap.accept("Defined as a method reference");

    }

    static void printStackTrace(String description) {
        new Throwable(description).printStackTrace();
    }
}