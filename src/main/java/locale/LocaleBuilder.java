package locale;

import java.util.Locale;

/**
 * Created by jfreire on 05.07.17.
 */
public class LocaleBuilder {

    public static void main(String[] args) {

        Locale aLocale = new Locale.Builder().setLanguage("fr").setRegion("IN").build();

        Locale locale = new Locale("fr", "IN");

        System.out.println("locale = " + aLocale.equals(locale));
    }
}
