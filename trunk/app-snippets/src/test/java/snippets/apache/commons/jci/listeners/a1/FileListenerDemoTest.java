package snippets.apache.commons.jci.listeners.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class FileListenerDemoTest {

    @Test
    public void test() throws IOException, InterruptedException {
        String path = this.getClass().getResource("").getFile() + "result.log";
        
        FileListenerDemo fl = new FileListenerDemo(false);
        fl.run(path);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String expected = sdf.format(new Date());
        
        Thread.sleep(1000);

        BufferedWriter bw = new BufferedWriter(new FileWriter(path)); 
        bw.write("Hello World");
        bw.flush();
        bw.close();
        
        String actual = fl.getDateChanged().get(0);
        assertEquals(expected, actual);
    }
}
