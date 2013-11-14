package snippets.security.hash.md5.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MD5Test {
    @Test
    public void test() {
        String expected = "b10a8db164e0754105b7a99be72e3fe5";
        String actual = MD5.encrypt("Hello World");
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
