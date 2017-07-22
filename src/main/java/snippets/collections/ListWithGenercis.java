package snippets.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jfreire on 05.07.17.
 */
public class ListWithGenercis {

    public static void main(String[] args) {

        List<? extends Number> list =new ArrayList<>();

  //      List<? extends Integer> list =new ArrayList<>();

        //Can't add elements as we don't know the exact type.
  //      list.add(new Integer(10));
    //    list.add(new Double(10.2));

        //Can retrieve elements only; we know the type is subclass of Number (it's an abstract class).
        list.get(0).byteValue();


        List<? super Number> list2 =new ArrayList<>();

        list2.add(new Integer(1));
        list2.add(new Integer(2));


        list2.get(0); //Only casts to Object as the safest.

    }
}
