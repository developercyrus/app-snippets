package snippets.jdk.net.socket.a2;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PortScanner {
    List<Integer> ports = new ArrayList<Integer>(); 
    
    public void start(String ip, int startPort, int endPort) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(20);
        int timeout = 200;
        final List<Future<ScanResult>> futures = new ArrayList<>();
        for (int port=startPort; port<=endPort; port++) {
            futures.add(portIsOpen(es, ip, port, timeout));
        }
        es.shutdown();
        for (final Future<ScanResult> f : futures) {
            if (f.get().isOpen()) {
                ports.add(f.get().getPort());
                System.out.println(f.get().getPort() +  " is open");                
            }
        }        
    }
    
    public Future<ScanResult> portIsOpen(ExecutorService es, final String ip, final int port, final int timeout) {
        return es.submit(new Callable<ScanResult>() {
            @Override 
            public ScanResult call() {                
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(ip, port), timeout);
                    socket.close();
                    return new ScanResult(port, true);
                } catch (Exception ex) {
                    return new ScanResult(port, false);
                }                                
            }
        });
    }
    
    public Integer[] getPorts() {
        return ports.toArray(new Integer[ports.size()]);
    }
}
