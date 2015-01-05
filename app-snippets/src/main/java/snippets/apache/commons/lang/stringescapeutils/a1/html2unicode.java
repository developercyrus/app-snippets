package snippets.apache.commons.lang.stringescapeutils.a1;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringEscapeUtils;

public class html2unicode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "&#716;e&#618;.bi&#720;&#712;es";
        String converted = StringEscapeUtils.unescapeHtml(str);
        System.out.println(str);
        System.out.println(converted);
    } 
}