package snippets.framework.junit.annotation.a1;

import org.junit.Ignore;
import org.junit.Test;

public class IgnoreAnnotatonTest {
    @Ignore("Not ready to test")
    @Test
    public void test() {
        System.out.println("Not ready to test");
    }
}
