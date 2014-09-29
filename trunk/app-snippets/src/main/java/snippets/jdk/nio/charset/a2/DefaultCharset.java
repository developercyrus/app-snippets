package snippets.jdk.nio.charset.a2;

import java.nio.charset.Charset;

public class DefaultCharset {
    public static void main(String[] args) {
        // Returns the default charset of this Java virtual machine. 
        Charset s = Charset.defaultCharset();
        System.out.println(s.toString());        
    }
}
