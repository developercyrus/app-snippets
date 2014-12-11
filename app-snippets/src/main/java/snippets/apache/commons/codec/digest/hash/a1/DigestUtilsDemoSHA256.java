package snippets.apache.commons.codec.digest.hash.a1;

import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtilsDemoSHA256 {
    public static void main(String[] args) {
        String str = "Hello World";        
        String result = DigestUtils.sha256Hex(str);
        System.out.println(result);
    }
}
