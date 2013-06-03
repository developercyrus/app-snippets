package snippets.apache.commons.io.fileutils.a2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class StringToFile {
    public static void write(String text, String encoding, String path) throws IOException {
        File f = new File(path);
        FileUtils.writeStringToFile(f, text, encoding);
    }
    
    public static String read(String encoding, String path) throws IOException {
        File f = new File(path);
        return FileUtils.readFileToString(f, encoding);
    }
}

