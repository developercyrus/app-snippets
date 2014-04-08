package snippets.jdk.net.socket.a2;

import static org.junit.Assert.assertEquals;

import org.eclipse.jetty.server.Server;
import org.junit.Test;

public class PortScannerTest {
    @Test
    public void test() throws Exception {
        Server server1 = new Server(1223);
        Server server2 = new Server(1334);
        PortScanner scanner = new PortScanner();
            
        
        server1.start();
        server2.start();  
        
        scanner.start("127.0.0.1", 1000, 1500);  
        Integer[] ports = scanner.getPorts();
        assertEquals(1223, ports[0].intValue());
        assertEquals(1334, ports[1].intValue());
        
        server1.stop();
        server2.stop();
    }
}
