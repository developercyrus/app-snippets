package snippets.jdk.lang.string.bytes.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AsciiArrayTest {

    @Test
    public void test() {
        String s1 = new String(AsciiArray.letters);
        assertEquals(s1, "ABCDEF");
        
        String s2 = new String(AsciiArray.letters, 2, 3);
        assertEquals(s2, "CDE");
    }
}
