package snippets.apache.commons.io.monitor.a1;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.junit.Test;

public class FolderMonitorTest {
    @Test
    public void changeByJava() throws Exception {
        final long pollingInterval = 5 * 1000;
        String path = (new File(FolderMonitorTest.class.getResource("").getPath())).getAbsolutePath();  
        
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));
        FileAlterationMonitor monitor = new FileAlterationMonitor(pollingInterval);
        FileAlterationListener listener = new FileAlterationListenerImpl();
        
        observer.addListener(listener);        
        monitor.addObserver(observer);
        monitor.start();    
        
        Runnable r = new FileWriterByJava();
        r.run();    
        
        Thread.sleep(5000);      
    }
    
    @Test
    public void changeByProcess() throws Exception {
        final long pollingInterval = 5 * 1000;
        String path = (new File(FolderMonitorTest.class.getResource("").getPath())).getAbsolutePath();  
        
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));
        FileAlterationMonitor monitor = new FileAlterationMonitor(pollingInterval);
        FileAlterationListener listener = new FileAlterationListenerImpl();
        
        observer.addListener(listener);        
        monitor.addObserver(observer);
        monitor.start();    
        
        Runnable r = new FileWriterByProcess();
        r.run();    
        
        Thread.sleep(5000);
    }
    
}

