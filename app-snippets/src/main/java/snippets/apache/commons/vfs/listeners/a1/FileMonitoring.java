package snippets.apache.commons.vfs.listeners.a1;

import java.io.File;
import org.apache.commons.vfs.FileChangeEvent;
import org.apache.commons.vfs.FileListener;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemManager;
import org.apache.commons.vfs.VFS;
import org.apache.commons.vfs.impl.DefaultFileMonitor;

public class FileMonitoring implements FileListener {
    // for versioning
    private static int counter = 0; 
    private static DefaultFileMonitor fileMonitor = null;
    private File configFile;

    public FileMonitoring(File configFile) {
        this.configFile = configFile;
    }

    public static void main(String[] args) throws FileSystemException, InterruptedException {
        FileMonitoring fileMonitoring = new FileMonitoring(new File("D:/tmp/WS_FTP.LOG"));
        fileMonitoring.startListening(fileMonitoring);
    }

    public void startListening(FileMonitoring fileMonitoring) throws FileSystemException, InterruptedException {
        FileSystemManager fsManager = VFS.getManager();
        FileObject fileObject = fsManager.toFileObject(configFile);
        if (fileMonitor == null) {
            fileMonitor = new DefaultFileMonitor(this);
            fileMonitor.addFile(fileObject);
            fileMonitor.start();
            
        }
        /*
        synchronized (fileMonitoring) {
            fileMonitoring.wait();
            startListening(fileMonitoring);
        }
        */
       
    }
    
    public void stopListening() {
        synchronized (this) {
            this.notifyAll();
        }
    }

    public void fileCreated(FileChangeEvent fce) throws Exception {
        throw new Exception();
    }

    public void fileDeleted(FileChangeEvent fce) throws Exception {
        throw new Exception();
    }

    public void fileChanged(FileChangeEvent fce) throws Exception {
        System.out.println("fileChanged:version-->" + ++counter);
        synchronized (this) { 
            this.notify();
        }
    }
    
    public int getCounter() {
        return counter;
    }
}