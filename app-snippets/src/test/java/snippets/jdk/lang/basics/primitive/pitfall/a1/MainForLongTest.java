package snippets.jdk.lang.basics.primitive.pitfall.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainForLongTest {

    @Test
    public void testAbnormal() {
        long expected = -813934592;
        assertEquals(expected, MainForLong.abnormal());
    }
    
    @Test
    public void testNormal() {
        long expected = 7776000000L; //without L, it will treat this as int, which is out of range;
        assertEquals(expected, MainForLong.normal());
    }
}
