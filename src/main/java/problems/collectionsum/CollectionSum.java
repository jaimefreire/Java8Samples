package problems.collectionsum;

import com.google.common.primitives.Ints;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jfreire on 21.07.17.
 */
public class CollectionSum {

    static List<Integer> list = new ArrayList();

    //Test if a collecion of numbers is equal to a pair
    public static void main(String[] args) throws IOException {

        //One million numbers, sorted
        list = Files.readAllLines(Paths.get("./src/main/java/problems/collectionsum/largeW.txt")).parallelStream()
                .map(x -> Integer.parseInt(x.trim())).sorted().collect(Collectors.toList());

        // 774392 + 490636 = 1265028
        Instant start = Instant.now();
        //System.out.println(new CollectionSum().testSimple(list, 1265028));
        System.out.println(String.format("Time with simple search: %s", Duration.between(start, Instant.now())));

        start = Instant.now();
        //System.out.println(new CollectionSum().testBinary(list, 1265028));
        System.out.println(String.format("Time with binary search: %s", Duration.between(start, Instant.now())));

        start = Instant.now();
        System.out.println(new CollectionSum().testLinear(list, 1265028));
        System.out.println(String.format("Time with linear search: %s", Duration.between(start, Instant.now())));

        //One million numbers, UNSORTED
        list = Files.readAllLines(Paths.get("./src/main/java/problems/collectionsum/largeW.txt")).parallelStream()
                .map(x -> Integer.parseInt(x.trim())).collect(Collectors.toList());

        start = Instant.now();
        System.out.println(new CollectionSum().testComp(list, 1265028));
        System.out.println(String.format("Time with complementary search: %s", Duration.between(start, Instant.now())));

        start = Instant.now();
        System.out.println(new CollectionSum().testComp(list, 774392));
        System.out.println(String.format("Time with complementary search: %s", Duration.between(start, Instant.now())));

        start = Instant.now();
        System.out.println(new CollectionSum().testLinear(list, 521490));
        System.out.println(String.format("Time with linear search unsorted(prob. won't work): %s", Duration.between(start, Instant.now())));


        // Unit tests //
        //Assert.assertTrue(new CollectionSum().testBinary(list3, 1) == null);
        //Assert.assertTrue(new CollectionSum().testBinary(list3, 3).equals(new Node(1, 2)));
    }

    //Class to return result.
    static class Node {
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
     * - Shitty quadratic runtime
     *
     * @param sum
     * @return
     */
    Node testSimple(List<Integer> list, int sum) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (sum == list.get(i) + list.get(j)) {
                    return new Node(list.get(i), list.get(j));
                }
            }
        }

        return null;
    }


    Node testBinary(List<Integer> list, int sum) {

        for (int i = 0; i < list.size(); i++) {
            int other = indexOf(Ints.toArray(list), sum - list.get(i));
            if (other != -1) {
                return new Node(list.get(i), list.get(other));
            }
        }

        return null;
    }

    //Algo. which works in linear time but only on a sorted list
    Optional<Node> testLinear(List<Integer> list, int sum) {

        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            int s = list.get(lo) + list.get(hi);
            //Decrease high
            if (s > sum) {
                hi--;
            }
            //Increase low
            else if (s < sum) {
                lo++;
            } else return Optional.of(new Node(list.get(lo), list.get(hi)));
        }
        return Optional.empty();
    }

    //Algo. which works in linear time but only on a sorted list
    Optional<Node> testComp(List<Integer> list, int sum) {
        //Constant lookup size
        Set<Integer> comp = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);

            if (comp.contains(sum-curr))
            {
                return Optional.of(new Node(curr, sum-curr));
            }
            else{
                comp.add(curr);
            }
        }
        return Optional.empty();
    }

    /**
     * For Binary search
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
