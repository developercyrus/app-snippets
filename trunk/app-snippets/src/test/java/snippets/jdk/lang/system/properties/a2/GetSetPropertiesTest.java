package snippets.jdk.lang.system.properties.a2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GetSetPropertiesTest {
    
    @Test
    public void test1() {       
        String key = "Resource/javax.jms.ConnectionFactory";
        String value = "connectionfactory:org.apache.activemq.ActiveMQConnectionFactory:tcp://localhost:61616";
        String expected = "connectionfactory:org.apache.activemq.ActiveMQConnectionFactory:tcp://localhost:61616";
        
        GetSetProperties.set(key, value);
        String actual = GetSetProperties.get(key);
        
        assertEquals(expected, actual);
    }
}
