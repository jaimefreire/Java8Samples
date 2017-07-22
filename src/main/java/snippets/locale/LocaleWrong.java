package snippets.locale;

import java.util.Locale;

/**
 * Created by jfreire on 06.07.17.
 */
public class LocaleWrong {

    public static void main(String[] args) {
        Locale loc = new Locale("Catalanian", "Catalunya");

        System.out.println(loc);
        System.out.println(loc.getDisplayLanguage());
        System.out.println(loc.getCountry());


    }
}
