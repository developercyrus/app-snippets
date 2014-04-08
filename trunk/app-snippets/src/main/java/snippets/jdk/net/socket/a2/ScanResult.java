package snippets.jdk.net.socket.a2;

public class ScanResult {
    private int port = -1;
    private boolean isOpen = false;
    
    public ScanResult(int port, boolean isOpen) {
        this.port = port;
        this.isOpen = isOpen;
    }
    public int getPort() {
        return port;
    }

    public boolean isOpen() {
        return isOpen;
    }
  }