package snippets.apache.commons.codec.digest.hash.a1;

import org.apache.commons.codec.digest.DigestUtils;

public class DigestUtilsDemoMD5 {
    public static void main(String[] args) {
        String str = "Hello World";        
        String result = DigestUtils.md5Hex(str);
        System.out.println(result);
    }
}
