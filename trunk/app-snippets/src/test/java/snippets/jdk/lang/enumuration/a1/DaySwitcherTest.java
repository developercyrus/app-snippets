package snippets.jdk.lang.enumuration.a1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DaySwitcherTest {

    @Test
    public void test() {
        assertEquals("Mondays are bad.", DaySwitcher.turn(Day.MONDAY));
        assertEquals("Fridays are better.", DaySwitcher.turn(Day.FRIDAY));
        assertEquals("Midweek days are so-so.", DaySwitcher.turn(Day.WEDNESDAY));
    }
}
