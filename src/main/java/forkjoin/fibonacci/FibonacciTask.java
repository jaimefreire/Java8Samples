package forkjoin.fibonacci;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by jfreire on 05.07.17.
 */
public class FibonacciTask extends RecursiveTask<Integer> {

    int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {

        //Base cases
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            //F_{n}=F_{n-1}+F_{n-2},}
            FibonacciTask fibonnaciN1 = new FibonacciTask(n - 1);
            FibonacciTask fibonnaciN2 = new FibonacciTask(n - 2);
            fibonnaciN2.fork();
            return fibonnaciN1.compute() + fibonnaciN2.join();
        }
    }


    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(100);

        doTheFib(pool, 0);
        doTheFib(pool, 1);
        doTheFib(pool, 10);
        doTheFib(pool, 25);
        doTheFib(pool, 50);
        doTheFib(pool, 100);


    }

    public static void doTheFib(ForkJoinPool pool, int n) {
        Instant start = Instant.now();
        System.out.println("FIB for  = " + n);
        FibonacciTask fib = new FibonacciTask(n);
        System.out.println("pool.invoke(fib) = " + pool.invoke(fib));
        Instant end = Instant.now();
        System.out.println("Total Time: " + Duration.between(start, end));

    }
}
