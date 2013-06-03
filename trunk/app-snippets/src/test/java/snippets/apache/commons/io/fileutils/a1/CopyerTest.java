package snippets.apache.commons.io.fileutils.a1;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import snippets.apache.commons.io.fileutils.a1.Copyer;

public class CopyerTest {    
    @Test
    public void test() throws IOException {
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMddHHmmss");
        String timestamp = fmt.print(dt);
        
        String orig = this.getClass().getResource("original.txt").getFile();  
        String dest = this.getClass().getResource("original.txt").getFile() + "." + timestamp; 
        
        //there should have a new file in [eclipse_workspace]\app-snippets\target\test-classes\snippets\apache\commons\io\fileutils\original.txt.[yyyyMMddHHmmss]
        
        System.out.println(orig);
        System.out.println(dest);
        
        Copyer c = new Copyer();
        assertEquals(true, c.copy(orig, dest));
    }
}
