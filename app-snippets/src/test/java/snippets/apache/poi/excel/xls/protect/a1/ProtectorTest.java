package snippets.apache.poi.excel.xls.protect.a1;

import java.io.IOException;

import org.junit.Test;

import snippets.apache.poi.excel.xls.protect.a1.Protector;

public class ProtectorTest {
    @Test
    public void test1() throws IOException  {
        String password = "password";
        String path = this.getClass().getResource("file.xls").getFile();
        
        Protector p = new Protector();
        p.setPassword(path, password);        
    }
}
