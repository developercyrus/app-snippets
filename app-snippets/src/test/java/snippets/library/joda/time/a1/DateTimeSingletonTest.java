package snippets.library.joda.time.a1;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeSingletonTest {
    @Test
    public void test() {
        DateTime dt = DateTimeSingleton.getInstance("2004-12-13T21:39:45.618");
        assertEquals(2004, dt.getYear());
        assertEquals(12, dt.getMonthOfYear());
        assertEquals(13, dt.getDayOfMonth());
        assertEquals(1, dt.getDayOfWeek()); //Monday
        assertEquals(348, dt.getDayOfYear());
        
        DateTime changed = dt.minusDays(2);
        assertEquals(11, changed.getDayOfMonth());
    }
}
