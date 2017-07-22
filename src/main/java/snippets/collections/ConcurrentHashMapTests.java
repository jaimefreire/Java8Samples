package snippets.collections;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jfreire on 04.07.17.
 */
public class ConcurrentHashMapTests {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger count = new AtomicInteger(0);
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>(1000, 1, 90);

        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int k = 0; k<100; k++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        map.put(i, String.valueOf(Math.random()));
                        count.incrementAndGet();
                    }
                }
            });
        }



    System.out.println("MAP: " + map);
    System.out.println("SIZE: " + count.get());
    }
}
