package snippets.jdk.io.file.a2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileMove {
    public static void main(String[] args) throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());        
        String fromFilePath = FileMove.class.getResource("from/file.txt").getFile();
        String toDirectoryPath = FileMove.class.getResource(".").getPath();
              
        File fromFile = new File(fromFilePath);
        File toDirectory = new File(toDirectoryPath);
        File toFile = new File(toDirectory, fromFile.getName() + "." + timeStamp);
        
        System.out.println("fromFile: " + fromFilePath);
        System.out.println("toFile: " + toFile.getPath());
        
        fromFile.renameTo(toFile);
        System.out.println("fromFile exists: " + fromFile.exists());
        System.out.println("toFile exists: " + toFile.exists()); 
                   
        Thread.sleep(2000);
        
        toFile.renameTo(fromFile);
        System.out.println("fromFile exists: " + fromFile.exists());
        System.out.println("toFile exists: " + toFile.exists());
    }
}
