package reducers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jfreire on 09.07.17.
 */
public class IntReducer {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList();

        l.add(1);
        l.add(2);
        l.add(4);


        int out = l.stream().reduce(3, Integer::sum);

        System.out.println("out = " + out);

    }
}
