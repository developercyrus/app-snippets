package snippets.monitor.file.jnotify.a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriterByJava implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
                
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());             
            PrintWriter out = new PrintWriter(new FileOutputStream(new File(FolderMonitorTest.class.getResource("file.txt").getFile()), true));              
            out.println(timeStamp + " FileWriterByJava");
            out.flush();
            out.close();        
        } catch (InterruptedException e) {            
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

