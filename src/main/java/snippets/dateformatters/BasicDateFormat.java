package snippets.dateformatters;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by jfreire on 04.07.17.
 */
public class BasicDateFormat {

    public static void main(String[] args) {


        //DateFormat df = DateFormat.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

        try{

        Date date2 = df.parse("11/28/89");
        System.out.println(df.format(date2));

        } catch( ParseException pe)
        {
            System.out.println("Parse Exception");
        }

    }
}
