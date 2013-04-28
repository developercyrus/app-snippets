package snippets.http.server.eclipse.jetty.a1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpExchange;

import org.junit.Test;

public class WebServerTest {

    @Test
    public void test() throws Exception {
        Server server = new Server(8080);
        server.setHandler(new GetContentHandler());
        server.start();
        
        HttpClient client = new HttpClient();
        client.start();
        ContentExchange exchange = new ContentExchange(true);
        exchange.setURL("http://localhost:8080");
        client.send(exchange);
        int exchangeState = exchange.waitForDone();
        if (exchangeState == HttpExchange.STATUS_COMPLETED) {
            assertEquals("It works", exchange.getResponseContent().trim());
        } 
        else {
            assertFalse(true);
        } 
        client.stop();
        server.stop();
        
        /*
        ContentExchange exchange = new ContentExchange() {
            protected void onResponseComplete() throws IOException {
                super.onResponseComplete();
                String responseContent = this.getResponseContent();
                assertEquals("It works", responseContent);
                System.out.println(responseContent);
            }
        };
        exchange.setURL("http://localhost:8081");
        client.send(exchange);
        client.stop();
        */
    }
}
