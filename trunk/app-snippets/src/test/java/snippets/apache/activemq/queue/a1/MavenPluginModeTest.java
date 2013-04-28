package snippets.apache.activemq.queue.a1;

import static org.junit.Assert.assertEquals;

import org.apache.activemq.broker.BrokerService;
import org.junit.Ignore;
import org.junit.Test;

import snippets.apache.activemq.queue.a1.Consumer2;
import snippets.apache.activemq.queue.a1.Producer;

public class MavenPluginModeTest { 
    /*
     *  If required to executing this test (by launch an actual activemq), type "mvn activemq:run" 
     *  Otherwise, add bypass this test by adding @Ignore
     *
     */
    
    @Ignore
    @Test
    public void test2() throws Exception {
        String uri = "tcp://localhost:61616";
        Producer producer = new Producer(uri);     
        Consumer2 consumer = new Consumer2(uri);
        
        producer.send("Hi consumer2");        
        Thread.sleep(1000);
        String expected = consumer.getMessage();
        
        assertEquals("Hi consumer2", expected);
    }
}
