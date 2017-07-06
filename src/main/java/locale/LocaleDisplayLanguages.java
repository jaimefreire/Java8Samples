package locale;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created by jfreire on 06.07.17.
 */
public class LocaleDisplayLanguages {

    public static void main(String[] args) {
        Locale loc = new Locale("EN", "France");

        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());

        localeStream.forEach(l -> System.out.println(loc.getDisplayLanguage(    l)));
    }
}
