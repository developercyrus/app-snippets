package snippets.jdk.nio.file.watchservice.a1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriterByProcess implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
                
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());             
            String path = (new File(FolderMonitorTest.class.getResource("").getPath())).getAbsolutePath();     
            
            Runtime rt = Runtime.getRuntime();
            String[] cmds = new String[3];
            
            cmds[0] = "cmd.exe" ;
            cmds[1] = "/C";
            cmds[2] = "echo FileWriterByProcess >> " + path + "/file.txt";
            
            Process proc = rt.exec(cmds); 
            
        } catch (InterruptedException e) {            
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {        
        Runnable r = new FileWriterByProcess();
        r.run();
    }
}

