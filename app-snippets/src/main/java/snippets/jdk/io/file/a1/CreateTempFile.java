package snippets.jdk.io.file.a1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CreateTempFile {
    public static void main(String[] args) {
        try {
            System.out.println(System.getProperty("java.io.tmpdir"));
            File tempFile = File.createTempFile("myfile", ".tmp");
            PrintStream out = new PrintStream(new FileOutputStream(tempFile));
            out.println("some text");
        } catch (IOException ex) {
            System.out.println("There was a problem creating/writing to the temp file");
            ex.printStackTrace();
        }
    }
}
