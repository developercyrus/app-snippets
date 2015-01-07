package snippets.jdk.jni.a2;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class HelloWorldTest {
    @Ignore
    @Test
    public void test() {
        HelloWorld h = new HelloWorld();
        String expected = "Hello World! This is from C.";
        String actual = h.fromC();
              
        assertEquals(expected, actual);
    }
}
