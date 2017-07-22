package problems.collectionsum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jfreire on 21.07.17.
 */
public class CollectionSum {

    final static List<Integer> list = new ArrayList();
    final static List<Integer> list3 = new ArrayList();

    //Test if a collecion of numbers is equal to a pair
    public static void main(String[] args) {

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(9);

        list3.add(1);
        list3.add(2);
        list3.add(4);
        list3.add(4);

        System.out.println(new CollectionSum().test(list, 3));
        System.out.println(new CollectionSum().test(list, 10));

        System.out.println(new CollectionSum().test(list3, 8));
        System.out.println(new CollectionSum().test(list3, 5));

        System.out.println(new CollectionSum().test(list3, 1));
        System.out.println(new CollectionSum().test(list3, 6));


    }

    class Node {
        int a;
        int b;

        Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Result: " + a + " - " + b;
        }
    }

    /**
     * Find pair of numbers in collection returning sum
     *
     * @param sum
     * @return
     */
    Node test(List<Integer> list, int sum) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (sum == list.get(i) + list.get(j)) {
                    return new Node(list.get(i), list.get(j));
                }
            }
        }

        return null;
    }
}
