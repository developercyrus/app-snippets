package snippets.jdk.util.regex.a3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindnReplace {
    public static void main(String[] args) {
        String text = "瘞��餅�瘞� http://www.yahoo.com ���餅���憭�敹�擖������舐���韏琿��擐砍云蝳24:7-8)  http://goo.gl/LtYB";
        change2Href(text);
    }

    public static void change2Href(String text) {
        String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        Matcher m2 = p.matcher(text);
        while (m.find()) {
            String find = m.group();
            System.out.println(find);
            text = text.replace(find, "<a href=\"" + find + "\">" + find + "</a>");
            System.out.println(text);
        }
    }

}
