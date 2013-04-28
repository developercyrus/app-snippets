package snippets.bytecode.javassist.reflect.method.parameter.a1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import snippets.bytecode.javassist.reflect.method.parameter.a1.ReflectMethodParameter;

public class ReflectMethodParameterTest {
    @Test
    public void test() {
        ReflectMethodParameter rmp = new ReflectMethodParameter();
        
        String[] expected = new String[2];
        expected[0] = "firstname";
        expected[1] = "age";
        
        assertArrayEquals(expected, rmp.getParamName("setInfo"));
    }
}
