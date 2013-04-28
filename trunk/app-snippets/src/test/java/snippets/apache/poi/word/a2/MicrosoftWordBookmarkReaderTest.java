package snippets.apache.poi.word.a2;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class MicrosoftWordBookmarkReaderTest {
    @Test
    public void test() throws FileNotFoundException, IOException {
        MicrosoftWordBookmarkReader r = new MicrosoftWordBookmarkReader();
        assertEquals("Bookmark_within_label", r.getBkmkMap().get("bk1"));
        assertEquals("", r.getBkmkMap().get("bk2"));
    }
    
    @Test
    public void testCount() throws FileNotFoundException, IOException {
        MicrosoftWordBookmarkReader r = new MicrosoftWordBookmarkReader();
        assertEquals(2, r.getBkmkCount());
    }
}
