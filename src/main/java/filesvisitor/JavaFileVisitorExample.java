package filesvisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by jfreire on 11.07.17.
 * <p>
 * Dead simple file system files and directories counter
 */
public class JavaFileVisitorExample implements FileVisitor {

    AtomicInteger fileCount = new AtomicInteger(0);

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Count: " + fileCount.incrementAndGet());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
        System.err.println("File system error on file: " + file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        //walkFile
        Instant start = Instant.now();
        Files.walkFileTree(Paths.get("/"), new JavaFileVisitorExample());
        System.out.println("Time taken wile fileVisitor: " + Duration.between(start, Instant.now()));
        //
        start = Instant.now();
        new StreamsFileCounter().walkThisWay("/");
        System.out.println("Time taken streams: " + Duration.between(start, Instant.now()));
        //
        start = Instant.now();
        System.out.println("Time taken directoryStream: " + Duration.between(start, Instant.now()));


    }

    /**
     * Recursive task
     */
    static class StreamsFileCounter<T> extends RecursiveTask<T>

    {
        public void walkThisWay(String s) {
            ForkJoinPool pool = new ForkJoinPool();
            System.out.println("compute walkThisWay = " + compute());
        }

        @Override
        protected T compute() {

            return (T) new Integer(0);

        }

        public void StreamsFileCounter(Path root) {

        }
    }

    /**
     * Recursive task
     */
    static class FileCounterViaExecutorService implements Runnable

    {
        public void walkESWay(String s) throws IOException {
            ExecutorService service = Executors.newFixedThreadPool(50);
            Path path = Paths.get("/");
            Stream<Path> dirs = Files.list(path);

            dirs.forEach(d -> d.toFile().listFiles());

           // System.out.println("compute walkESWay = " + service.invokeAll(dirs));
        }

        @Override
        public void run() {

        }
    }

    class DirectoryStreamWalker

    {
        Path path = Paths.get("/");
        AtomicInteger count = new AtomicInteger(0);

        void walk(File f) throws IOException {
            try {
                if (f.isFile())
                    count.incrementAndGet();
                else if (f.isDirectory()) {
//                    Stream.of(f.listFiles()).forEach(this.walk());
                }
            } catch (Exception e) {
                //ignore
            }
        }
    }
}
