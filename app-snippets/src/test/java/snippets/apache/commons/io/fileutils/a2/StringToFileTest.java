package snippets.apache.commons.io.fileutils.a2;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class StringToFileTest {    
    @Test
    public void test() throws IOException {
        String text = "台灣中";
        String encoding = "UTF-8";
        String path = this.getClass().getResource("").getFile() + "output.txt";
        
        StringToFile.write(text, encoding, path);
        String actual = StringToFile.read(encoding, path);
        String expected = "台灣中";
        
        System.out.println(actual);
        
        assertEquals(expected, actual);
    }
}
