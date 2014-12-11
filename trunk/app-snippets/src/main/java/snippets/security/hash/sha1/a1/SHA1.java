package snippets.security.hash.sha1.a1;

import java.security.MessageDigest;

public class SHA1 {

    public static String encrypt(String str) {
        return encrypt(str, "SHA-1");
    }

    public static String encrypt(String str, String encType) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance(encType);
            md.update(str.getBytes());
            result = toHexString(md.digest());
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
        String actual = SHA1.encrypt("Hello World");
        System.out.println(actual);
    }
}
