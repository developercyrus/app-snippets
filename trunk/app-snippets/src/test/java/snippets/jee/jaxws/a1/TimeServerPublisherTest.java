package snippets.jee.jaxws.a1;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

public class TimeServerPublisherTest {
    @Test
    public void test() throws MalformedURLException {
        TimeServerPublisher.main(null);       
        
        String expected = "JAXWS TimeServer";        
        URL url = new URL("http://localhost:9876/ts?wsdl");
        QName qname = new QName("http://a1.jaxws.jee.snippets/", "TimeServerImplService");       
        Service service = Service.create(url, qname);
        TimeServer eif = service.getPort(TimeServer.class);
        eif.setName(expected);
        assertEquals(expected + " is processed.", eif.getName());
        
        System.out.println(eif.getTimeAsString());
        System.out.println(eif.getTimeAsElapsed());
    }
}
