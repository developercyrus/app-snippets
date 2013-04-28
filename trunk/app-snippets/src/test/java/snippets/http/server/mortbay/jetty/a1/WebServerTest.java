package snippets.http.server.mortbay.jetty.a1;

import java.net.URL;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebServerTest {

    @Test
    public void test() throws Exception {
        Server server = new Server(8080);
        Context contentOkContext = new Context(server, "/getContentOk");
        contentOkContext.setHandler(new GetContentOkHandler());
        server.start();
        
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/getContentOk"));
        assertEquals("It works", result);
        
        server.stop();
    }
}
