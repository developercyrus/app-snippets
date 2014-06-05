package snippets.apache.commons.validator.email.a1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmailAddressCheckerTest {
    
    @Test
    public void test() {
        assertTrue(EmailAddressChecker.check("!#$%&'*+-/=?^_`{|}~@gmail.com"));
        assertTrue(EmailAddressChecker.check("first.last@gmail.com"));
        assertFalse(EmailAddressChecker.check("first.@gmail.com"));
        assertFalse(EmailAddressChecker.check("first..last@gmail.com"));        
    }
}
