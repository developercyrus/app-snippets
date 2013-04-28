package snippets.jdk.lang.system.process.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CallCommandPrompt {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        String[] cmds = new String[3];
        cmds[0] = "cmd.exe" ;
        cmds[1] = "/C" ;
        cmds[2] = "dir /b c:";
        
        Process proc = rt.exec(cmds);
        InputStream stdin = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(stdin);
        BufferedReader br = new BufferedReader(isr);
        
        String line = null;
        System.out.println("<OUTPUT>");
        while ( (line = br.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("</OUTPUT>");
        int exitVal = proc.waitFor();            
        System.out.println("Process exitValue: " + exitVal);
    }
}
