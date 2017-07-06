package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jfreire on 18.06.17.
 */
public class FilesTest {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/Users/jfreire/Documents/blade.html");

        Files.find(path.getParent(), 1, // k1
                (Path p, BasicFileAttributes b) -> p.toString().endsWith(".txt") && Files.isDirectory(p)) // k2
        .collect(Collectors.toList())
        .forEach(System.out::println);

        long count = Files.readAllLines(path).parallelStream() // k3
        .flatMap(p -> Stream.of(p.split(" "))) // k4
                .map(s -> s.toLowerCase())
                .count(); // k5
                //.forEach(System.out::println);
        System.out.println(count);
    }
}