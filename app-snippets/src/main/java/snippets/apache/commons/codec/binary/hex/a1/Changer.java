package snippets.apache.commons.codec.binary.hex.a1;

import org.apache.commons.codec.binary.Hex;

public class Changer {
    public static String toHex(String str) {
        return new String(Hex.encodeHex(str.getBytes()));
    }   
    
    public static void main(String[] args) {
        System.out.println(toHex("衞"));
    }
}
