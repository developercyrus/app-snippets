package snippets.jdk.lang.string.format.hex.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChangerTest {
    @Test
    public void test() {
        String str = "衞";
        String expected = "e8a19e";
        String actual = Changer.toHex(str);
        
        assertEquals(expected, actual);
    }
}