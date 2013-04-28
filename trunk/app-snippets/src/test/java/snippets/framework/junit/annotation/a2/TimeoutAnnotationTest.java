package snippets.framework.junit.annotation.a2;

import org.junit.Test;

public class TimeoutAnnotationTest {
    @Test(timeout = 3000)  
    public void test() throws InterruptedException {  
        Thread.sleep(2000);
    }
}
