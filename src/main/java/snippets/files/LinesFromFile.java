package snippets.files;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by jfreire on 06.07.17.
 */
public class LinesFromFile {

    public static void main(String[] args) throws Exception{

        List<String> lines = new ArrayList<>();


        //System.out.println(System.getProperties());

        //Current path from user.dir
        Stream<String> stream = Files.lines(Paths.get("./src/main/java/files/test.txt"), Charset.defaultCharset());
        //Map is a function that returns the results of applying an operation to all the elements of the Stream
        stream.map(String::trim).filter(s -> !s.isEmpty()).forEach(lines::add);

        System.out.println(lines);


    }
}
