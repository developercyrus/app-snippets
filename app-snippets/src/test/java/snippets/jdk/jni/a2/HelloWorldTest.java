package snippets.jdk.jni.a2;

import org.junit.Ignore;
import org.junit.Test;

public class HelloWorldTest {
    @Ignore
    @Test
    public void test() {
        HelloWorld h = new HelloWorld();
        String expected = "hello world!";
        //String actual = h.fromC();
              
        //assertEquals(expected, actual);
    }
}
