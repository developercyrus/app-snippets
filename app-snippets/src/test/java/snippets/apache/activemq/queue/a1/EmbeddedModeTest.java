package snippets.apache.activemq.queue.a1;

import static org.junit.Assert.assertEquals;

import org.apache.activemq.broker.BrokerService;
import org.junit.Test;

import snippets.apache.activemq.queue.a1.Consumer1;
import snippets.apache.activemq.queue.a1.Consumer2;
import snippets.apache.activemq.queue.a1.Consumer3;
import snippets.apache.activemq.queue.a1.Producer;

public class EmbeddedModeTest {
    @Test
    public void test1() throws Exception {
        String uri = "vm://localhost?broker.persistent=false";
        BrokerService broker = new BrokerService();  
        broker.setPersistent(false);  
        broker.setUseJmx(false);  
        broker.start();  
                
        
        Producer producer = new Producer(uri);
        Consumer1 consumer = new Consumer1(uri);
        
        producer.send("Hi consumer1");
        Thread.sleep(1000);
        String expected = consumer.getMessage();
        
        assertEquals("Hi consumer1", expected);
        
        broker.stop();
    }
    
    @Test
    public void test2() throws Exception {
        String uri = "vm://localhost?broker.persistent=false";
        BrokerService broker = new BrokerService();  
        broker.setPersistent(false);  
        broker.setUseJmx(false);  
        broker.start();  
                
        Producer producer = new Producer(uri);     
        Consumer2 consumer = new Consumer2(uri);
        
        producer.send("Hi consumer2");        
        Thread.sleep(1000);
        String expected = consumer.getMessage();
        
        assertEquals("Hi consumer2", expected);
        
        broker.stop();
    }
    
    
    @Test
    public void test3() throws Exception {
        String uri = "vm://localhost?broker.persistent=false";
        BrokerService broker = new BrokerService();  
        broker.setPersistent(false);  
        broker.setUseJmx(false);  
        broker.start();  
                
        Producer producer = new Producer(uri);   
        Consumer3 consumer = new Consumer3(uri);
        consumer.start();
        
        producer.send("Hi consumer3");        
        Thread.sleep(1000);
        String expected = consumer.getMessage();
        
        assertEquals("Hi consumer3", expected);
        
        broker.stop();
    }
}
