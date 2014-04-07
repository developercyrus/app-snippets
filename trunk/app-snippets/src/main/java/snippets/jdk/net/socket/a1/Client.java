package snippets.jdk.net.socket.a1;

import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    private final String address = "127.0.0.1";
    private final int port = 8765;

    public Client() {
        Socket client = new Socket();
        InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
        try {
            client.connect(isa, 10000);
            BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
            out.write("hello world!".getBytes());
            out.flush();
            out.close();
            out = null;
            client.close();
            client = null;

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Client();
    }
}
