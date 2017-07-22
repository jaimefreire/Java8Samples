package snippets.locks;

/**
 * Created by jfreire on 09.07.17.
 */

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        new ReentrantReadWriteLockTest();
    }

    ReentrantReadWriteLockTest() {

        ReadWriteLock rwLock = new ReentrantReadWriteLock(true);

        rwLock.writeLock().lock();
        avgScore();
        rwLock.writeLock().unlock();
    }

    public void avgScore() {
        double sum = 0;
        int i = 0;

        for (i = 0; i < sum; i++) {
            sum += 0;
        }
    }
}

