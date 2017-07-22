package problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jfreire on 18.07.17.
 */
public class StringPermute {

    private String apply(String string) {

        return string.chars().sorted().toString(); //Collectors.joining(","));

//        return Stream.of(string).map() .collect(Collectors.joining());

        //return Stream.of(string). sorted()
        //      .peek(System.out::println).collect(Collectors.joining());
    }

    private String applyBasic(String string) {
        StringBuffer sb = new StringBuffer(string.length());
        for (int i = string.length() - 1; i >= 0; i--) {
            sb.append(string.charAt(i));
        }
        //System.out.println("sb.toString() = " + sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        sun.jvm.hotspot.utilities.Assert.that(new StringPermute().applyBasic("TEST TEST").equals("TSET TSET"), "Test 4 failed");
        sun.jvm.hotspot.utilities.Assert.that(new StringPermute().applyBasic("").equals(""), "Test 5 failed");
        sun.jvm.hotspot.utilities.Assert.that(new StringPermute().applyBasic("CAGARRO").equals("ORRAGAC"), "Test 6 failed");
        sun.jvm.hotspot.utilities.Assert.that(new StringPermute().applyBasic("EL LE").equals("EL LE"), "Test 7 failed");
        //
        sun.jvm.hotspot.utilities.Assert.that(new StringPermute().apply("TEST TEST").equals("TSET TSET"), "Test 1 failed");
        sun.jvm.hotspot.utilities.Assert.that(new StringPermute().apply("POCOYO").equals("OYOCOP"), "Test 2 failed");
        sun.jvm.hotspot.utilities.Assert.that(new StringPermute().apply("").equals(""), "Test 3 failed");
        //
    }
}
