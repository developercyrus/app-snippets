package snippets.apache.commons.lang.stringutils.a4;

import org.apache.commons.lang3.StringUtils;

public class ContainsNone {
    
    public static boolean containsNone(String str, char[] DISALLOWED_CHAR) {        
        return StringUtils.containsNone(str, DISALLOWED_CHAR);        
    }
        
    public static void main(String[] args) {
        final char[] DISALLOWED_CHAR = {'-', ','};
        System.out.println(containsNone("abcdefghijk", DISALLOWED_CHAR));
    }
}
