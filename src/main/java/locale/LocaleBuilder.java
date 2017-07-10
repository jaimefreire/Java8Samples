package locale;

import java.util.Locale;

/**
 * Created by jfreire on 05.07.17.
 */
public class LocaleBuilder {

    public static void main(String[] args) {

        Locale aLocale = new Locale.Builder().setLanguage("fr").setRegion("IN").build();

        //Setting language is optional but..
        Locale aLocale2 = new Locale.Builder().setRegion("IN").build();

        System.out.println("aLocale2 = " + aLocale2);

        //This statement returns empty
        System.out.println("aLocale2 = " + aLocale2.getDisplayLanguage());


        Locale locale = new Locale("fr", "IN");

        System.out.println("locale = " + aLocale.equals(locale));
    }
}
