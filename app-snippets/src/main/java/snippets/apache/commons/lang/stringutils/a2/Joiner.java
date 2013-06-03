package snippets.apache.commons.lang.stringutils.a2;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

public class Joiner {
    public static String combine(String[] args, String sep) {
        return StringUtils.join(args, sep);
    }
        
    public static void main(String[] args) {
        String[] texts = {"台灣","中",""};
        System.out.println(combine(texts, SystemUtils.LINE_SEPARATOR));
    }
}
