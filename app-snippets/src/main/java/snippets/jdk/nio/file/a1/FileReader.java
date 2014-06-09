package snippets.jdk.nio.file.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resourceUrl = FileReader.class.getResource("readme.txt");
        
        Path file = Paths.get(resourceUrl.toURI());
        BufferedReader reader = Files.newBufferedReader(file, Charset.defaultCharset());
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
