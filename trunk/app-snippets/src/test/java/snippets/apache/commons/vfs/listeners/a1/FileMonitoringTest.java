package snippets.apache.commons.vfs.listeners.a1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileMonitoringTest {
    @Test
    public void test() throws InterruptedException, IOException {
        String path = this.getClass().getResource("file.txt").getFile();
        FileMonitoring fileMonitoring = new FileMonitoring(new File(path));
        fileMonitoring.startListening(fileMonitoring);
        
        BufferedWriter out = new BufferedWriter(new FileWriter(path,true));
        Date d = new Date();
        String date = d.toString();
        out.write(date);
        out.flush();
        out.close();
        
        synchronized (fileMonitoring) {
            fileMonitoring.wait();
        }
        
        assertEquals(1, fileMonitoring.getCounter());
        
        fileMonitoring.stopListening();
    }
}
