package snippets.formatters;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Optional;

/**
 * Created by jfreire on 18.07.17.
 */
public class NumberFormatters {

    public static void main(String[] args) {

        Optional<Number> n = Optional.empty();
        Optional<Number> nn = Optional.empty();

        DecimalFormat df = new DecimalFormat("#.######");
        try {
            n = Optional.of(NumberFormat.getInstance().parse("3.141592"));
            nn = Optional.of(df.parse("3.141592"));
        } catch (ParseException e) {
            System.err.println("nf: Error : " + e);
        }

        System.out.println("nf = " + n.orElse(0).equals(3.141592));
        System.out.println("nn.toString() = " + nn.toString());


    }

}
