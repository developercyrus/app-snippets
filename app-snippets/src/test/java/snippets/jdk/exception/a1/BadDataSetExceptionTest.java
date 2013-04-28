package snippets.jdk.exception.a1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BadDataSetExceptionTest {
    @Test
    public void test() {
        BadDataSetException e = new BadDataSetException();
        assertEquals("Bad Data Set", e.getError());
    }
}
