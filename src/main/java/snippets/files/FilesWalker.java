package snippets.files;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jfreire on 17.07.17.
 */
public class FilesWalker {

    public static void main(String[] args) throws IOException {
        Files.walk(Paths.get("/Users/jfreire"), 5, FileVisitOption.FOLLOW_LINKS)
                .peek(System.out::println)
                .filter(p -> p.getFileName().endsWith("txt"))
                .forEach(p -> System.out.println("Found file: " + p.toAbsolutePath()));

    }
}
