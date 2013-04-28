package snippets.apache.activemq.topic.a1;

import static org.junit.Assert.assertEquals;

import org.apache.activemq.broker.BrokerService;
import org.junit.Test;

public class EmbeddedModeTest { 
    @Test
    public void test2() throws Exception {
        String uri = "vm://localhost?broker.persistent=false";
        BrokerService broker = new BrokerService();  
        broker.setPersistent(false);  
        broker.setUseJmx(false);  
        broker.start();  
                
        Producer producer = new Producer(uri);     
        Consumer2 consumerOne = new Consumer2(uri, "One");
        Consumer2 consumerTwo = new Consumer2(uri, "Two");
        
        producer.send("Hi consumer");        
        Thread.sleep(1000);
        String expectedOne = consumerOne.getMessage();
        String expectedTwo = consumerTwo.getMessage();
        
        assertEquals("Hi consumerOne", expectedOne);
        assertEquals("Hi consumerTwo", expectedTwo);
        
        broker.stop();
    }
}