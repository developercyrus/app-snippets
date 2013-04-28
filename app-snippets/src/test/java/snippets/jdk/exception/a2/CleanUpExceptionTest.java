package snippets.jdk.exception.a2;

import org.junit.Test;

public class CleanUpExceptionTest {
    
    @Test(expected=CleanUpException.class)
    public void test() throws Exception  {
       throw new CleanUpException();
    }
}
