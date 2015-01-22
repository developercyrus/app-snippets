package snippets.jdk.io.piped.a1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    /*
     * read from System.out in a thread, and redirect to System.err in another thread
     * Both threads are connected by PipedOutputStream and PipedInputStream
     */
    
    public static void main(String[] args) throws InterruptedException, IOException {
        PipedOutputStream out = new PipedOutputStream(); 
        PipedInputStream in = new PipedInputStream(out);  
         
        Generator g = new Generator(out);
        Capturer c = new Capturer(in);
        
        ExecutorService service = Executors.newFixedThreadPool(2);       
        service.execute(g);        
        service.execute(c);
        
        Thread.sleep(5 * 1000);
        g.stop();
        out.close();
        
        service.shutdown();
    }
}