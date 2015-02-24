package snippets.library.juniversalchardet.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class CharsetDetectorTest {
    
    @Test
    public void t1() throws Exception {
        String path = this.getClass().getResource("UTF-8").getFile();
        String actual = CharsetDetector.detect(path);
        assertEquals("UTF-8", actual);
    }
    
    @Test
    public void t2() throws Exception {
        String path = this.getClass().getResource("UTF-16LE").getFile();
        String actual = CharsetDetector.detect(path);
        assertEquals("UTF-16LE", actual);
    }
    
    @Test
    public void t3() throws Exception {
        String path = this.getClass().getResource("UTF-16BE").getFile();
        String actual = CharsetDetector.detect(path);
        assertEquals("UTF-16BE", actual);
    }
    
    @Test
    public void t4() throws Exception {
        String path = this.getClass().getResource("BIG5").getFile();
        String actual = CharsetDetector.detect(path);
        assertEquals("BIG5", actual);
    }
    
    //Currently not supported by Java
    @Ignore
    @Test
    public void t5() throws Exception {
        String path = this.getClass().getResource("GB2312").getFile();
        String actual = CharsetDetector.detect(path);
        assertEquals("GB2312", actual);
    }
}
