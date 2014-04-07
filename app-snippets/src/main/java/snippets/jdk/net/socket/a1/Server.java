package snippets.jdk.net.socket.a1;

import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server extends Thread {
    private final boolean isOut = false;
    private ServerSocket server;
    private final int port = 8765;
 
    public Server() {
        try {
            server = new ServerSocket(port); 
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public void run() {
        Socket socket = null;
        BufferedInputStream in;
 
        System.out.println("server started!");
        while (!isOut) {            
            try {
                synchronized (server) {
                    socket = server.accept();
                }
                socket.setSoTimeout(15000);
 
                in = new BufferedInputStream(socket.getInputStream());
                byte[] b = new byte[1024];
                String data = "";
                int length;
                while ((length = in.read(b)) > 0) {
                    data += new String(b, 0, length);
                }
 
                System.out.println("data :" + data);
                in.close();
                in = null;
                socket.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
 
        }
    }
 
    public static void main(String args[]) {
        (new Server()).start();
    }
 
}