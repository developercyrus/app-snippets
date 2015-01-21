package snippets.jdk.nio.file.watchservice.a1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FolderMonitorTest {

    @Test
    public void changeByJava() throws Exception {               
        String path = (new File(FolderMonitorTest.class.getResource("").getPath())).getAbsolutePath();         
        Path folder = Paths.get(path);
        FolderMonitor f = new FolderMonitor(folder);
        
        Runnable r = new FileWriterByJava();
        r.run();
        
        f.run();
    }
    
    @Test
    public void changeByProcess() throws Exception {               
        String path = (new File(FolderMonitorTest.class.getResource("").getPath())).getAbsolutePath();         
        Path folder = Paths.get(path);
        FolderMonitor f = new FolderMonitor(folder);
        
        Runnable r = new FileWriterByProcess();
        r.run();
        
        f.run();
    }
}
