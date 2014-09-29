package snippets.jdk.lang.string.bytes.a2;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

public class CharByteLength {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "0123456789";

        SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();     
        Set<String> charSet = availableCharsets.keySet();
        for (String charsetName : charSet) {
            print(text, charsetName);                   
        }        
    }
    
    public static void print(String text, String charsetName) throws UnsupportedEncodingException {        
        if (charsetName.contains("UTF")) {            
            System.out.printf("%15s: %d\n", charsetName, text.getBytes(charsetName).length);
        }
    }
}
