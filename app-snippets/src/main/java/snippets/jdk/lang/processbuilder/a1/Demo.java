package snippets.jdk.lang.processbuilder.a1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException {
        String[] cmd = {"cmd", "/c", "dir/b"};
        String path = Demo.class.getResource("").getFile();
        File currentDirectory = new File(path);
        int exitValue = -1;
        String os = null;

        final StringBuffer sb = new StringBuffer();
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb = pb.redirectErrorStream(true);
        os = pb.environment().get("OS");
        pb.directory(currentDirectory);
        final Process p = pb.start();
        try {      
            new Thread() {
                @Override
                public void run() {
                    final InputStream is = p.getInputStream();
                    final InputStreamReader isr = new InputStreamReader(is);
                    final BufferedReader br = new BufferedReader(isr);
                    String line;
                    try {
                        try {
                            while ((line = br.readLine()) != null) {
                                sb.append(line).append('\n');
                            }
                        } catch (EOFException e) {
                            e.printStackTrace();
                        } finally {
                            br.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            try {
                p.waitFor();
                exitValue = p.exitValue();
            }

            catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        } finally {
            p.getInputStream().close();
            p.getOutputStream().close();
            p.getErrorStream().close();      
        }

        System.out.println("OS: " + os);
        System.out.println("Run Command: " + Arrays.toString(cmd));
        System.out.println("exitValue: " + exitValue);    
        System.out.println("stdout: ");
        System.out.println(sb);
    }

}