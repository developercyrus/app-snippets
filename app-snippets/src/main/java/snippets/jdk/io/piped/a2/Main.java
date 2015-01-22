package snippets.jdk.io.piped.a2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;

public class Main {

    public String capture(PrintStream ps, Functional func) throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        BufferedReader br = new BufferedReader(new InputStreamReader(pis));
        StringWriter sw = new StringWriter();
        String output = null;
        try {
            PrintStream original = ps;
            System.setOut(new PrintStream(pos));

            func.execute();
            System.out.flush();

            pos.close();
            System.setOut(original);

            String line = null;
            while ((line=br.readLine())!=null) {
                sw.write(line+System.getProperty("line.separator"));
            }      
            output = sw.toString();
        }
        finally {
            br.close();
            sw.close();
        }
        return output;
    }

   

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        String s = m.capture(System.out, new SystemOut());
        System.out.println(s);
    }
}