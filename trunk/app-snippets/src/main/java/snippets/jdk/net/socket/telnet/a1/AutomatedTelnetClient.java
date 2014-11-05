package snippets.jdk.net.socket.telnet.a1;
import java.io.InputStream;
import java.io.PrintStream;

import org.apache.commons.net.telnet.TelnetClient;

public class AutomatedTelnetClient {
    private final TelnetClient telnet = new TelnetClient();
    private InputStream in;
    private PrintStream out;

    public AutomatedTelnetClient(String server) {
        try {
            /*
             * http://codeinsecurity.wordpress.com/2013/03/13/password-cracking-with-vmware-auth-daemon/
             */
            telnet.connect(server, 912);

            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
            
            this.readUntil("\r\n");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();
            while (true) {
                System.out.print(ch);
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String value) {
        try {
            out.println(value);
            out.flush();
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        try {
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            AutomatedTelnetClient telnet = new AutomatedTelnetClient("localhost");
            telnet.sendCommand("USER peter");
            telnet.sendCommand("PASS 12345678");
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}