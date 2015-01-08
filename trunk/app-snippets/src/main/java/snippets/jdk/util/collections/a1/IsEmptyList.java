package snippets.jdk.util.collections.a1;

import java.util.Collections;
import java.util.List;

public class IsEmptyList {
    public static void main(String args[]) {
        List list = Collections.EMPTY_LIST;
        System.out.println(list.size());

        // For the type-safe example use the following methods.
        List<String> s = Collections.emptyList();
        System.out.println(s.size());
    }
}
