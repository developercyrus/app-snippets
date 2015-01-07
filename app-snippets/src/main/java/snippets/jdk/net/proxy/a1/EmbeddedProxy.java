package snippets.jdk.net.proxy.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.littleshoot.proxy.HttpProxyServer;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

public class EmbeddedProxy {
    public static void main(String[] args) throws IOException {
        HttpProxyServer server = DefaultHttpProxyServer.bootstrap().withPort(8099).start();
                     
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8099));
        URL url = new URL("http://www.google.com");
        HttpURLConnection uc = (HttpURLConnection)url.openConnection(proxy);
        uc.connect();
                
        StringBuffer page = new StringBuffer();
        String line;
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        while ((line = in.readLine()) != null){
           page.append(line + "\n");
        }
        System.out.println(page);
        
        server.stop();
    }
}
