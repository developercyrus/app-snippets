package snippets.jdk.io.piped.a1;

import java.io.PipedOutputStream;
import java.io.PrintStream;

public class Generator implements Runnable{
    private boolean isRunning = true;
    
    public Generator(PipedOutputStream out) {
        System.setOut(new PrintStream(out));
    }
    
    @Override
    public void run() {    
        System.out.println("Generator started");
        while (this.isRunning) {            
            try {                
                System.out.println("Generator: Hello World!");
                System.out.flush(); 
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }    
    
    public void stop() {
        this.isRunning = false;
        System.out.println("Generator ended");
    }
}
