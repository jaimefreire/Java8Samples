package snippets.suppliers;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Created by jfreire on 19.07.17.
 */
public class SuppliersSamples {

    public static void main(String[] args) {
        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();
        //
        Supplier<ArrayList<Double>> s3 = () -> new ArrayList<Double>();

        System.out.println(s3.get().add(3D));

        System.out.println(s1.get());
        System.out.println(s2.get());



    }
}
