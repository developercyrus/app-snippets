package snippets.apache.activemq.topic.a1;

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

public class Consumer2 implements MessageListener{
    private String topic = "TestTopic";
    
    private Connection connection = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;
    private Session session = null;
    private String msg;
    private String name;
    
    public Consumer2(String uri, String name) throws JMSException, InterruptedException {
        this.name = name;
        
        ConnectionFactory factory = new ActiveMQConnectionFactory(uri);  
        connection = factory.createConnection();
        connection.start();
        
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        destination = session.createTopic(topic);

        consumer = session.createConsumer(destination);
        consumer.setMessageListener(this); 
    }
    
    @Override
    public void onMessage(Message message) { 
        if (message instanceof TextMessage) {
            TextMessage txtMsg = (TextMessage) message;
            try {
                msg = txtMsg.getText() + name;
                System.out.println("received: " + msg);
            } catch (JMSException e) {
                e.printStackTrace();                        
            }                    
        }      
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
