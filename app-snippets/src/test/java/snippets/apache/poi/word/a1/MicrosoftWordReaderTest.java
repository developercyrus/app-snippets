package snippets.apache.poi.word.a1;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import snippets.apache.poi.word.a1.MicrosoftWordReader;

public class MicrosoftWordReaderTest {
    @Test
    public void test() throws FileNotFoundException, IOException {
        MicrosoftWordReader r = new MicrosoftWordReader();
        assertEquals("Hello World! This is text saved in Word 2003.", r.getText().trim());
    }
}
