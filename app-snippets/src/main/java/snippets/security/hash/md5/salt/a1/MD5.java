package snippets.security.hash.md5.salt.a1;

import java.security.MessageDigest;

public class MD5 {

    public static String encrypt(String str) {
        return encrypt(str, "123", "MD5");
    }

    public static String encrypt(String str, String salt, String encType) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance(encType);
            md.reset();
            md.update(salt.getBytes());
            result = toHexString(md.digest(str.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String toHexString(byte[] in) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < in.length; i++) {
            String hex = Integer.toHexString(0xFF & in[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    public static void main(String[] args) {
        String actual = MD5.encrypt("Hello World");
        System.out.println(actual);
    }
}
