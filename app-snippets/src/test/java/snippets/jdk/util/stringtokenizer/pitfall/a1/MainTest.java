package snippets.jdk.util.stringtokenizer.pitfall.a1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MainTest {
    
    @Test
    public void testAbnormal() {
        String s = "123###4#5###6#7###hello###wo#rld###9";        
        String[] expected = {"123", "4", "5", "6", "7", "hello", "wo", "rld", "9"}; 
        
        assertArrayEquals(expected, Main.splitByTokenizer(s));
    }
    
    @Test
    public void testNormal() {
        String s = "123###4#5###6#7###hello###wo#rld###9";        
        String[] expected = {"123", "4#5", "6#7", "hello", "wo#rld", "9"}; 
        
        assertArrayEquals(expected, Main.splitByRegex(s));
    }
}
