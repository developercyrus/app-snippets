package snippets.apache.commons.jci.listeners.a1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.jci.listeners.FileChangeListener;
import org.apache.commons.jci.monitor.FilesystemAlterationListener;
import org.apache.commons.jci.monitor.FilesystemAlterationMonitor;
import org.apache.commons.jci.monitor.FilesystemAlterationObserver;

public class FileListenerDemo {
    List<String> dateChanged = new ArrayList<String>();
    boolean isRunEver = false;
    
    public FileListenerDemo(boolean isRunEver) {
        this.isRunEver =  isRunEver;
    }
    
    public void run(String path) {
        FilesystemAlterationMonitor fam = new FilesystemAlterationMonitor();
        final File configFile = new File(path);

        System.out.println("Watching " + configFile.getAbsolutePath());

        FilesystemAlterationListener listener = new FileChangeListener() {
            @Override
            public void onStop(FilesystemAlterationObserver pObserver) {
                super.onStop(pObserver);

                if (hasChanged()) {
                    System.out.println("Configuration change detected " + configFile);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    dateChanged.add(sdf.format(new Date()));
                }
            }
        };

        fam.addListener(configFile, listener);
        fam.start();

        while (true && this.isRunEver) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public List<String> getDateChanged() {
        return dateChanged;
    }
}
