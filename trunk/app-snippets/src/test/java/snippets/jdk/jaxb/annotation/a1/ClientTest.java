package snippets.jdk.jaxb.annotation.a1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Test;

public class ClientTest {
    @Test
    public void testMarshal() throws JAXBException {
        Person person = new Person();
        person.setName("Hello World");
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><name>Hello World</name></person>";
        
        JAXBContext c = JAXBContext.newInstance(Person.class);
        Writer writer = new StringWriter();
        c.createMarshaller().marshal(person, writer); 
        assertEquals(expected, writer.toString());
    }
    
    @Test
    public void testUnmarshal() throws JAXBException {
        Person expected = new Person();
        expected.setName("Hello World");
        String person = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><name>Hello World</name></person>";
        
        JAXBContext c = JAXBContext.newInstance(Person.class);
        Reader reader = new StringReader(person);
        Person actual = (Person) c.createUnmarshaller().unmarshal(reader);
        assertEquals(expected.getName(), actual.getName());
    }
}
