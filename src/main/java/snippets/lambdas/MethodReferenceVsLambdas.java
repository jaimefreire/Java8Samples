package snippets.lambdas; /**
 * Created by jfreire on 06.07.17.
 */

import java.util.function.Consumer;

public class MethodReferenceVsLambdas {


    public static void main(String[] args) {
        Consumer<String> lambda = s -> printStackTrace(s);
        lambda.accept("Defined as a lambda");

        Consumer<String> methodRef = MethodReferenceVsLambdas::printStackTrace;
        methodRef.accept("Defined as a method reference");

    }

    static void printStackTrace(String description) {
        new Throwable(description).printStackTrace();
    }

}

