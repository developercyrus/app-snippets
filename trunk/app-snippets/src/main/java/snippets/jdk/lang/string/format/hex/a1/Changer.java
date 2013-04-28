package snippets.jdk.lang.string.format.hex.a1;

import java.math.BigInteger;

public class Changer {
    public static String toHex(String arg) {
        return String.format("%x", new BigInteger(1, arg.getBytes()));
    }
    
    public static void main(String[] args) {
        String str = "衞";
        String actual = Changer.toHex(str);
        
        System.out.println(actual);
    }
}
