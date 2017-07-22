package problems.stringcompress;

import com.sun.tools.javac.util.StringUtils;
import org.junit.Assert;

/**
 * Created by jfreire on 22.07.17.
 */
public class StringCompress {

    final String input;


    StringCompress(String input) {
        this.input = input;
    }

    String compress() {

        //
        char[] inputArray = input.toCharArray();
        int count = 1;
        char letter = inputArray[0];
        ;
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < inputArray.length; i++) {

            if (letter != inputArray[i]) {
                append(count, result, letter);
                //
                count = 1;
                letter = inputArray[i];
            } else {
                count++;
            }
        }
        return append(count, result, letter).toString();
    }

    String uncompress() {
        char[] inputArray = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i + 1 < inputArray.length && Character.isDigit(inputArray[i + 1])) {
                count = Integer.parseInt("" + inputArray[i + 1]);

                for (int j = 0; j < count; j++) {
                    result.append(inputArray[i]);
                }
                i += 1; //Increment additional
            } else {
                result.append(inputArray[i]);
            }
        }
        return result.toString();
    }

    /**
     * Appends char to {@link StringBuilder}
     *
     * @param count  int
     * @param result StringBuilder
     * @param letter char to append
     * @return {@link StringBuilder}
     */
    StringBuilder append(final int count, final StringBuilder result, final char letter) {
        if (count > 1) {
            result.append(letter).append(count);
        } else {
            result.append(letter);
        }
        return result;
    }


    public String compressAlternate() {
        //
        char[] array = new char[128];
        int index = 0;
        char last = input.charAt(0);
        int count = 1;
        //
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == last) {
                count++;
            } else {
                index = setChar(array, last, index, count);
                last = input.charAt(i);
                count = 1;
            }
        }

        //Update with last sequence
        index = setChar(array, last, index, count);
        return String.valueOf(array).trim();
    }

    int setChar(char[] array, char c, int index, int count) {
        array[index] = c;
        index++;

        //Convert the count to a string, then to an array of chars
        char[] cnt = String.valueOf(count).toCharArray();

        //Copy chars from biggest to smallest
        for (char x : cnt) {
            array[index] = x;
            index++;
        }

        return index;
    }


    /**
     * StringCompress baby
     *
     * @param args
     */

    public static void main(String[] args) {
        Assert.assertTrue(new StringCompress("aaabbc").compress().equals("a3b2c"));

        Assert.assertTrue(new StringCompress("aaabbc").compressAlternate().equals("a3b2c1"));


        Assert.assertTrue(new StringCompress("aaaaa").compress().equals("a5"));
        Assert.assertTrue(new StringCompress("abc").compress().equals("abc"));
        Assert.assertTrue(new StringCompress("aaabbcc").compress().equals("a3b2c2"));
        Assert.assertTrue(new StringCompress("aaaaaaaaaaaabbccdddddddt").compress().equals("a12b2c2d7t"));
        //
        System.out.println(new StringCompress("a2b2c2d7t").uncompress());
        Assert.assertTrue(new StringCompress("abc").uncompress().equals("abc"));
        Assert.assertTrue(new StringCompress("a5").uncompress().equals("aaaaa"));
        Assert.assertTrue(new StringCompress("a3b2c2").uncompress().equals("aaabbcc"));
        Assert.assertTrue(new StringCompress("a2b2c2d7t").uncompress().equals("aabbccdddddddt"));
        Assert.assertTrue(new StringCompress("a12b2c2d7t").uncompress().equals("aaaaaaaaaaaabbccdddddddt"));
    }
}