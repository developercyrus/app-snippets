package snippets.apache.poi.excel.xlsx.unprotect.a1;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class UnprotectorTest {
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
