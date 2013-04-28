package snippets.apache.commons.jexl.a1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {    
    @Test
    public void test() throws Exception {
        String exp = "if ((x * 2) == 5) { y = 1; } else {y = 2;}";
        double val = 2.5;
        String expected = "1";
        String actual = App.getValue(exp, val);
        
        assertEquals(expected, actual);
    }
}
