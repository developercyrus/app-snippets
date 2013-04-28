package snippets.jdk.lang.string.xor.a1;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.IOException;

public class StringXORer {

    public String encode(String s, String key) {
        return base64Encode(xorWithKey(s.getBytes(), key.getBytes()));
    }

    public String decode(String s, String key) {
        return new String(xorWithKey(base64Decode(s), key.getBytes()));
    }

    private byte[] xorWithKey(byte[] a, byte[] key) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ key[i%key.length]);
        }
        return out;
    }

    private byte[] base64Decode(String s) {
        try {
            BASE64Decoder d = new BASE64Decoder();
            return d.decodeBuffer(s);
        } catch (IOException e) {throw new RuntimeException(e);}
    }

    private String base64Encode(byte[] bytes) {
        BASE64Encoder enc = new BASE64Encoder();
        return enc.encode(bytes).replaceAll("\\s", "");
    }
    
    public static void main(String[] args) {
        String s = "hello world";
        String key = "george";
        
        StringXORer xor = new StringXORer();
        String encrypted = xor.encode(s, key);
        String decrypted = xor.decode(encrypted, key);
        
        System.out.println(encrypted);
        System.out.println(decrypted);        
    }
}