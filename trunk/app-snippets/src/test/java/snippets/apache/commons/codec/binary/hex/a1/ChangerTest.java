package snippets.apache.commons.codec.binary.hex.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Ignore;
import org.junit.Test;

public class ChangerTest {
    @Test
    public void test() {
        String str = "衞";
        String expected = "e8a19e";
        String actual = Changer.toHex(str.trim());
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test2() throws IOException {
        String path = this.getClass().getResource("file.txt").getFile();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        
        String str = br.readLine();        
        String expected = "e8a19e";
        String actual = Changer.toHex(str);
        
        assertEquals(expected, actual);
    }
}
