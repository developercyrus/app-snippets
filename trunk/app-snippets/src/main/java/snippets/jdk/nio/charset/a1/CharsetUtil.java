package snippets.jdk.nio.charset.a1;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

public class CharsetUtil {
    SortedMap<String, Charset> availableCharsets;
    
    public CharsetUtil() {
        availableCharsets = Charset.availableCharsets();        
    }
    
    public boolean isAvailable(String key) {
        Set<String> keySet = availableCharsets.keySet();
        return keySet.contains(key);
    }
        
    public static void main(String[] args) {
        CharsetUtil c = new CharsetUtil(); 
        System.out.println(c.isAvailable("x-UTF-16LE-BOM"));
    }
}
