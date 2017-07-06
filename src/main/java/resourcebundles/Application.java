package resourcebundles;

import java.util.Locale;
import java.util.ResourceBundle;

public class Application {

    public static void main(String[] args) {

        // en_US
        System.out.println("Current Locale: " + Locale.getDefault());
        ResourceBundle mybundle = ResourceBundle.getBundle("jaimón");

        // read MyLabels_en_US.properties
        System.out.println("Say how are you in US English: " + mybundle.getString("how_are_you"));

        Locale.setDefault(new Locale("es", "ES"));

        // read MyLabels_ms_MY.properties
        System.out.println("Current Locale: " + Locale.getDefault());
        mybundle = ResourceBundle.getBundle("jaimón");
        System.out.println("Say how are you in Malaysian Malaya language: " + mybundle.getString("how_are_you"));

    }

}