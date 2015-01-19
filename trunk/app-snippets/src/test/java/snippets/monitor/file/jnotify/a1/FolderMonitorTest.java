package snippets.monitor.file.jnotify.a1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Field;

import org.junit.Test;

public class FolderMonitorTest {
    @Test
    public void changeByJava() throws Exception {
        String path = (new File(FolderMonitorTest.class.getResource("").getPath())).getAbsolutePath();       
        /* 
             1. equivalent to -Djava.library.path=...
             2. If without the last three lines, it's read only. Reference: https://stackoverflow.com/questions/5419039/is-djava-library-path-equivalent-to-system-setpropertyjava-library-path
         */        
        System.setProperty("java.library.path", path);
        Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
        fieldSysPath.setAccessible(true);
        fieldSysPath.set(null, null);

        // it doesn't capture the change by programming, but only user action
        Runnable r = new FileWriterByJava();
        r.run();
        
        FolderMonitor monitor = new FolderMonitor(5000);
        monitor.listen(path);
        assertEquals(monitor.isCreated(), false);
        assertEquals(monitor.isDeleted(), false);
        assertEquals(monitor.isModified(), false);
        assertEquals(monitor.isRenamed(), false);
    }
    
    @Test
    public void changeByProcess() throws Exception {
        //public static void main(String[] args) throws Exception {
            String path = (new File(FolderMonitorTest.class.getResource("").getPath())).getAbsolutePath();       
            /* 
                 1. equivalent to -Djava.library.path=...
                 2. If without the last three lines, it's read only. Reference: https://stackoverflow.com/questions/5419039/is-djava-library-path-equivalent-to-system-setpropertyjava-library-path
             */        
            System.setProperty("java.library.path", path);
            Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);

            // it does capture the change by process of command prompt
            Runnable r = new FileWriterByProcess();
            r.run();
            
            FolderMonitor monitor = new FolderMonitor(5000);
            monitor.listen(path);
            assertEquals(monitor.isCreated(), false);
            assertEquals(monitor.isDeleted(), false);
            assertEquals(monitor.isModified(), true);
            assertEquals(monitor.isRenamed(), false);
        }
}
