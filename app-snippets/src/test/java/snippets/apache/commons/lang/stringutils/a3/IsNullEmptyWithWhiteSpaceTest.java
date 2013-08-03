package snippets.apache.commons.lang.stringutils.a3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IsNullEmptyWithWhiteSpaceTest {

    @Test
    public void test1() {
        String nullStr = null;
        String emptyStr = "";
        String whiteStr = " ";
        String normalStr = "a";
        
        assertTrue(IsNullEmptyWhiteSpace.isTrue(nullStr));
        assertTrue(IsNullEmptyWhiteSpace.isTrue(emptyStr));
        assertTrue(IsNullEmptyWhiteSpace.isTrue(whiteStr));
        assertFalse(IsNullEmptyWhiteSpace.isTrue(normalStr));
    }
}
