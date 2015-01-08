package snippets.jdk.util.regex.a2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trimmer {
    public static void main(String[] args) {
        String s = "記錄 1 到 10 (共 339 個記錄).";
        Pattern p = Pattern.compile("\\p{InCJKUnifiedIdeographs}");        
        Matcher m = p.matcher(s);
        if (m.find()) {
            s = m.replaceAll("");
        }
        System.out.println(s);
        
        p = Pattern.compile("\\(.*\\)");
        m = p.matcher(s);
        if (m.find()) {
            s = m.group().replace("(", "").replace(")", "").trim();
        }
        System.out.println(s);
    }
}