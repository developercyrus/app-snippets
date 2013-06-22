package snippets.jdk.lang.string.replaceall.a1;

import java.util.Set;
import java.util.TreeSet;

public class SetToMultiLine {
    public static String convert(Set<String> s) {
        return s.toString().replaceAll(", |[\\[\\]]", "\n").trim();
    }
    
    public static void main(String[] args) {
        Set<String> s = new TreeSet<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        
        System.out.println(s);
        System.out.println(convert(s));        
    }
}
 