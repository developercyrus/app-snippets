package snippets.jdk.lang.string.replaceall.a1;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class SetToMultiLineAllTest {
    @Test
    public void test() {
        StringBuffer e = new StringBuffer();
        e.append("a\n");
        e.append("b\n");
        e.append("c");
        String expected = e.toString();
        System.out.println(expected);
        
        Set<String> s = new TreeSet<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        String actual = SetToMultiLine.convert(s);
        System.out.println(actual);
        
        assertEquals(expected, actual);
    }
}
