package snippets.apache.commons.lang.arrayutils.a1;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class ToPrimitive {
    public static int[] convert(List<Integer> list) {
        return ArrayUtils.toPrimitive(list.toArray(new Integer[0]));
    }
}
