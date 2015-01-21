package snippets.jdk.nio.channels.filechannel.a1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

import org.apache.commons.lang.time.StopWatch;

/*
 * https://stackoverflow.com/questions/7379469/filechannel-transferto-for-large-file-in-windows
 */

public class FileCopier {
    public static void main(String[] args) throws IOException {
        /*
            10GB = 10 * 1024 * 1024 * 1024 Byte 
         
            D:\tmp>fsutil file createnew 10GB 10737418240
            File D:\tmp\10GB is created
         */
        
        File s = new File("D:/tmp/10GB");
        File dio = new File("D:/tmp/10GB.io");
        File dnio = new File("D:/tmp/10GB.nio");

        StopWatch t = new StopWatch();
        
        t.start();
        ioCopy(s, dio);
        t.stop();
        // 77 seconds
        System.out.println(t.getTime()/1000 + " seconds");  

        t.reset();
        
        t.start();
        nioCopy(s, dnio);
        t.stop();
        // 117 seconds, why it's even slower 
        System.out.println(t.getTime()/1000 + " seconds");   //NIO transferTo is fast only with small files and becomes very slow on larger files  <-- need to verify this statement yet
    }

    public static void nioCopy(File s, File d) throws IOException {
        FileChannel in = new FileInputStream(s).getChannel();
        FileChannel out = new FileOutputStream(d).getChannel();
        
        // magic number for Windows, (64MB - 32KB)
        int maxCount = (64 * 1024 * 1024) - (32 * 1024);
        long size = in.size();
        long position = 0;
        while (position < size) {
            // On the Windows platform, you can't copy a file bigger than 64Mb, an Exception in thread "main" java.io.IOException: Insufficient system resources exist to complete the requested service is thrown.
            // in.transferTo(0, in.size(), out); 
            position += in.transferTo(position, maxCount, out);
        }
        in.close();
        out.close();        
    }

    public static void ioCopy(File s, File d) throws IOException {
        final int BUFF_SIZE = 1 * 1024 * 1024; // 1MB
        final byte[] buffer = new byte[BUFF_SIZE];

        InputStream in = new FileInputStream(s);
        FileOutputStream out = new FileOutputStream(d);

        int count = -1;
        while ((count = in.read(buffer)) != -1 ) {
            out.write(buffer, 0, count);
        }
        out.close();
        in.close();
    }
}
