package snippets.jdk.io.piped.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;

public class Capturer implements Runnable {
    private BufferedReader br = null;

    public Capturer(PipedInputStream in) throws IOException {  
        br = new BufferedReader(new InputStreamReader(in));
    }
    
    @Override
    public void run() {   
        System.err.println("Capturer started");        
        try {           
            String line = null;
            while ((line=br.readLine())!=null) {
                System.err.println("Capturer: " + line);                
            }             
        } catch (IOException e) {            
            e.printStackTrace();
        }   
        System.err.println("Capturer ended");
    }
    
}
