package snippets.apache.commons.lang.stringutils.a3;

import org.apache.commons.lang3.StringUtils;

public class IsNullEmptyWhiteSpace {
    public static boolean isTrue(String str) {        
        return StringUtils.isBlank(str);  
    }
    
    public static void main(String[] args) {        
        String nullStr = null;
        String emptyStr = "";
        String whiteStr = " ";
        String normalStr = "a";
        
        System.out.println(isTrue(nullStr));
        System.out.println(isTrue(emptyStr));
        System.out.println(isTrue(whiteStr));
        System.out.println(isTrue(normalStr)); 
    }
}
