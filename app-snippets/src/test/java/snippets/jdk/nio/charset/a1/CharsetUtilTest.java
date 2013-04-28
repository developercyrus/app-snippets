package snippets.jdk.nio.charset.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharsetUtilTest {
    
    @Test 
    public void test() {
        CharsetUtil c = new CharsetUtil();
        boolean expected = true;
        boolean actual = c.isAvailable("x-UTF-16LE-BOM");
        
        assertEquals(expected, actual);
    }
}
