package snippets.jdk.nio.file.watchservice.a1;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class FolderMonitor implements Runnable {    
    private WatchService service = null;

    public FolderMonitor(Path path) throws IOException  {
        Boolean isFolder = (Boolean) Files.getAttribute(path, "basic:isDirectory", NOFOLLOW_LINKS);
        if (!isFolder) {
            throw new IllegalArgumentException("Path: " + path + " is not a folder");
        }
        
        System.out.println("Watching path: " + path);
                    
        FileSystem fs = path.getFileSystem ();
        service = fs.newWatchService();
        path.register(service, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    } 
    
    @Override
    public void run() {    
        try {
            //WatchKey key = service.take();
            WatchKey key = service.poll(5, TimeUnit.SECONDS);
            if (key != null) {
                for(WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();
             
                    if (kind == OVERFLOW) {
                        continue;
                    } else if (kind == ENTRY_CREATE) {
                        System.out.println(kind.name() + ": " + fileName + " was created");
                    } else if (kind == ENTRY_DELETE) {
                        System.out.println(kind.name() + ": " + fileName + " was deleted");
                    } else if (kind == ENTRY_MODIFY) {
                        System.out.println(kind.name() + ": " + fileName + " was modified");
                    }
                }                                      
            }
            
            Thread.sleep(5000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }   
}