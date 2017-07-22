package problems;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jfreire on 18.07.17.
 */
public class ReplaceSpaces {

    public String apply(String string) {
        return Stream.of(string).map(x -> x.replace(" ", "20%")).collect(Collectors.joining());
    }

    /**
     * @param string
     * @return
     */
    public String applyBasic(String string) {
        StringBuffer outputBuf = new StringBuffer(string.length());
        for (char s : string.toCharArray()) {
            if (s == ' ')
                outputBuf.append("20%");
            else
                outputBuf.append(s);
        }
        return outputBuf.toString();
    }


    public static void main(String[] args) {

        sun.jvm.hotspot.utilities.Assert.that(new ReplaceSpaces().apply("TEST TEST").equals("TEST20%TEST"), "Test 1 failed");
        sun.jvm.hotspot.utilities.Assert.that(new ReplaceSpaces().apply("TEST").equals("TEST"), "Test 2 failed");
        sun.jvm.hotspot.utilities.Assert.that(new ReplaceSpaces().apply("T T T").equals("T20%T20%T"), "Test 3 failed");
        sun.jvm.hotspot.utilities.Assert.that(new ReplaceSpaces().apply("T T").equals("T20%T"), "Test 4 failed");
        sun.jvm.hotspot.utilities.Assert.that(new ReplaceSpaces().apply("").equals(""), "Test 5 failed");

        sun.jvm.hotspot.utilities.Assert.that(new ReplaceSpaces().applyBasic("TEST TEST").equals("TEST20%TEST"), "Test 6 failed");
        sun.jvm.hotspot.utilities.Assert.that(new ReplaceSpaces().applyBasic("T T T").equals("T20%T20%T"), "Test 7 failed");

    }
}