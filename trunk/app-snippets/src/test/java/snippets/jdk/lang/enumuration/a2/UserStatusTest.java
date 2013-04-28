package snippets.jdk.lang.enumuration.a2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserStatusTest {
    @Test
    public void test() {
        assertEquals("A", UserStatus.ACTIVE.getStatusCode());
        
    }
}
