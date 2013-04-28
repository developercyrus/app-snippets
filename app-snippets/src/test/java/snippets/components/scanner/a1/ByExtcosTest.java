package snippets.components.scanner.a1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Ignore;
import org.junit.Test;

public class ByExtcosTest {
    @Ignore
    @Test
    public void testClassName() {
        String[] actual = ByExtcos.getClassName();
        String[] expected = {"snippets.apache.commons.beanutils.a1.Person", "snippets.apache.commons.beanutils.a1.PersonTest"};
        assertArrayEquals(actual, expected);
    }
    
    @Test
    public void testAnnotatedClassName() {
        String[] actual = ByExtcos.getAnnotatedClassName();
        String[] expected = {"snippets.framework.junit.annotation.a1.IgnoreAnnotatonTest"};
        assertArrayEquals(actual, expected);
    }
}
