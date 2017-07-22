package snippets.formatters;

import java.text.DecimalFormat;

/**
 * Created by jfreire on 18.07.17.
 */
public class DecimalFormatter {

    public static void main(String[] args) {
        DecimalFormat one = new DecimalFormat("###,###,###.###");
        double d = 1234567.437;
        System.out.println(one.format(d)); // 1,234,567.437

        DecimalFormat two = new DecimalFormat("000,000,000.00000");
        System.out.println(two.format(d)); // 001,234,567.43700

        DecimalFormat three = new DecimalFormat("$#,###,###.##");
        System.out.println(three.format(d)); // $1,234,567.44
    }
}
