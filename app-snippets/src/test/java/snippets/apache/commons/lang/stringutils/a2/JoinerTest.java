package snippets.apache.commons.lang.stringutils.a2;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

public class JoinerTest {
    @Test
    public void test() {
        String[] texts = {"台灣","中",""};
        String expected = "台灣" + SystemUtils.LINE_SEPARATOR + "中" + SystemUtils.LINE_SEPARATOR + "";
        String actual = Joiner.combine(texts, SystemUtils.LINE_SEPARATOR);
        
        assertEquals(expected, actual);
    }

    
}
