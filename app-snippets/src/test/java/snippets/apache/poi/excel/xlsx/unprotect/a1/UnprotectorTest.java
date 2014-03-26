package snippets.apache.poi.excel.xlsx.unprotect.a1;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

public class UnprotectorTest {
    /*
        seems like security policy can't be used 
        unresolved problem, workaround by bypass the test
 
        java.lang.ExceptionInInitializerError: null
        at javax.crypto.JceSecurity.setupJurisdictionPolicies(JceSecurity.java:254)
        at javax.crypto.JceSecurity.access$000(JceSecurity.java:48)
        at javax.crypto.JceSecurity$1.run(JceSecurity.java:78)
        at java.security.AccessController.doPrivileged(Native Method)
        at javax.crypto.JceSecurity.<clinit>(JceSecurity.java:76)
        at javax.crypto.Cipher.getInstance(Cipher.java:499)
        at org.apache.poi.poifs.crypt.EcmaDecryptor.getCipher(EcmaDecryptor.java:117)
        at org.apache.poi.poifs.crypt.EcmaDecryptor.verifyPassword(EcmaDecryptor.java:87)
        at snippets.apache.poi.excel.xlsx.unprotect.a1.Unprotector.unlock(Unprotector.java:26)
        at snippets.apache.poi.excel.xlsx.unprotect.a1.UnprotectorTest.test1(UnprotectorTest.java:19)
         
     */
    @Ignore
    @Test
    public void test1() throws IOException, GeneralSecurityException, SAXException  {
        String password = "password";
        String path = this.getClass().getResource("file.xlsx").getFile();

        Unprotector p = new Unprotector();
        String expected = "hello world!";      
        String actual = p.unlock(path, password);
        
        assertEquals(expected, actual);
        
    }
}
