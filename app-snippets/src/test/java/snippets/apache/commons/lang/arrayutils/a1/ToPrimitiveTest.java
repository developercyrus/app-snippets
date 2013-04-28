package snippets.apache.commons.lang.arrayutils.a1;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ToPrimitiveTest {
    @Test
    public void test() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        
        int[] expected = {1, 2};
        int[] actual = ToPrimitive.convert(list);
        assertArrayEquals(expected, actual);
    }
}
