package snippets.security.encode.base64.a1;

import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class Base64Codec {
    public static void main(String[] args) {
        try {
            String text = "hello world";
            String txtEncoded;
            String txtDecoded;
            String urlEncoded;
            String urlDecoded;

            txtEncoded = new String(Base64.encodeBase64(text.getBytes()));
            urlEncoded = URLEncoder.encode(txtEncoded, "utf-8");
            urlDecoded = URLDecoder.decode(urlEncoded, "utf-8");
            txtDecoded = new String(Base64.decodeBase64(urlDecoded.getBytes()));
            
            System.out.println("txt encoded: " + txtEncoded);
            System.out.println("url encoded: " + urlEncoded);
            System.out.println("url decoded: " + urlDecoded);
            System.out.println("txt decoded: " + txtDecoded);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
