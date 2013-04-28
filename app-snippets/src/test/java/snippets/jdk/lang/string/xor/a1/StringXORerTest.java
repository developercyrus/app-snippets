package snippets.jdk.lang.string.xor.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringXORerTest {
    @Test
    public void test1() {
        String s = "hello world";
        String key = "george";
        String expected = "DwADHghFEAodHgM=";
        
        StringXORer xor = new StringXORer();        
        assertEquals(expected, xor.encode(s, key));
    }
    
    @Test
    public void test2() {
        String s = "DwADHghFEAodHgM=";
        String key = "george";
        String expected = "hello world";
        
        StringXORer xor = new StringXORer();        
        assertEquals(expected, xor.decode(s, key));
    }
}
