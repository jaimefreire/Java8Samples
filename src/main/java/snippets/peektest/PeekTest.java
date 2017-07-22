package snippets.peektest;

import java.util.stream.IntStream;

/**
 * Created by jfreire on 05.07.17.
 */
public class PeekTest {
    public static void main(String[] args) {
        IntStream stream = createAStreamAndPerformSomeSideEffectWithPeek();
        System.out.println("Second. I should be the second group of prints");
        consumeTheStream(stream);
    }

    //peek incorporates side effects on the stream as it maps the values on the stream so when foreach runs and the stream is consumed, it is no longer the original stream 1,2,3
    private static IntStream createAStreamAndPerformSomeSideEffectWithPeek() {
        return IntStream.of(1, 2, 3).peek(number -> System.out.println(String.format("First. My number is %d", number))).map(number -> number + 1);
    }

    private static void consumeTheStream(IntStream stream) {
        stream.filter(number -> number % 2 == 0).forEach(number -> System.out.println(String.format("Third. My number is %d", number)));
    }
}
