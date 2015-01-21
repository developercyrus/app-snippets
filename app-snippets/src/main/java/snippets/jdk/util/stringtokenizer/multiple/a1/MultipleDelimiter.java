package snippets.jdk.util.stringtokenizer.multiple.a1;

import java.util.StringTokenizer;

public class MultipleDelimiter {
    /*
        expected
        
        http
        192
        173
        15
        36
        8084
     */
    public static void main(String[] args) {
        String msg = "http://192.173.15.36:8084/";
        StringTokenizer st = new StringTokenizer(msg, "://.");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
