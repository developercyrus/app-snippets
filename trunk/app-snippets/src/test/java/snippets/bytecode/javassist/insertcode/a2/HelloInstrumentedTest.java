package snippets.bytecode.javassist.insertcode.a2;

import static org.junit.Assert.assertEquals;
import javassist.CannotCompileException;
import javassist.NotFoundException;

import org.junit.Test;

import snippets.bytecode.javassist.insertcode.a2.HelloInstrumented;

public class HelloInstrumentedTest {
    @Test
    public void test() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        HelloInstrumented hi = new HelloInstrumented();
        hi.setMessage("Hello World!");
        assertEquals("Peter, Hello World!", hi.getMessage());
    }
}
