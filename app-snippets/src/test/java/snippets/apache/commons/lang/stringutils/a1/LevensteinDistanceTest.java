package snippets.apache.commons.lang.stringutils.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LevensteinDistanceTest {
    @Test
    public void test() {
        int expected = 8;
        int actual = LevensteinDistance.getDistanceValue("insurance", "coffee");
        
        assertEquals(expected, actual);
    }
}
