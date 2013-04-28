package snippets.security.encrypt.base16.a1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Base16CodecTest {
    
    @Test
    public void test1() {
        String original = "hello world";
        String expected = "68656C6C6F20776F726C64";
        assertEquals(expected, Base16Codec.encode(original.getBytes()));

    }
    
    @Test
    public void test2() {
        String original = "68656C6C6F20776F726C64";
        String expected = "hello world";
        assertEquals(expected, new String(Base16Codec.decode(original)));
    }
}
