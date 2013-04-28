package snippets.apache.activemq.queue.a1;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer1 {
    private String subject = "TestQueue";
    
    private Connection connection = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;
    private Session session = null;
    private String msg;
    
    public Consumer1(String uri) throws JMSException, InterruptedException {
        ConnectionFactory factory = new ActiveMQConnectionFactory(uri);  
        connection = factory.createConnection();
        connection.start();
        
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue(subject);

        consumer = session.createConsumer(destination);
        
        consumer.setMessageListener(new MessageListener() { 
            @Override
            public void onMessage(Message message) { 
                if (message instanceof TextMessage) {
                    TextMessage txtMsg = (TextMessage) message;
                    try {
                        msg = txtMsg.getText();
                        System.out.println("received: " + msg);
                    } catch (JMSException e) {
                        e.printStackTrace();                        
                    }                    
                }      
            } 
     
        });  
    }
    
    public String getMessage() {
        return msg;
    }
    
    public void close() throws JMSException {
        //session.commit();  
        session.close();  
        connection.close();
    }
}
