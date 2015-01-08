package snippets.components.scanner.a1;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class ByExtcosTest {
    @Test
    public void testClassName() {
        String[] actual = ByExtcos.getClassName();        
        String[] expected = {"snippets.apache.commons.beanutils.a1.Person", "snippets.apache.commons.beanutils.a1.PersonTest"};   
        
        //if preverse order, it will fail
        //assertArrayEquals(actual, expected);
        
        //workaround
        Arrays.sort(actual);
        Arrays.sort(expected);
        System.out.println(Arrays.equals(actual, expected));
        assertArrayEquals(actual, expected);
    }
    
    @Test
    public void testAnnotatedClassName() {
        String[] actual = ByExtcos.getAnnotatedClassName();
        String[] expected = {"snippets.framework.junit.annotation.a1.IgnoreAnnotatonTest"};
        assertArrayEquals(actual, expected);
    }    
}
