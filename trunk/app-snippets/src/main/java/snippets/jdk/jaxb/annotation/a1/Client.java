package snippets.jdk.jaxb.annotation.a1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;

public class Client {    
    public static void main(String[] args) throws JAXBException {
        Person personIn = new Person();
        personIn.setName("Hello World");
        
        JAXBContext c = JAXBContext.newInstance(Person.class);
        // will print <?xml version="1.0" encoding="UTF-8" standalone="yes"?><person><name>TEST</name></person>
        c.createMarshaller().marshal(personIn, System.out); 
        System.out.println();
        
        Person personOut = (Person) c.createUnmarshaller().unmarshal( IOUtils.toInputStream( "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><person><name>John</name></person>" ) );
        System.out.println(personOut.getName()); // print TEST
    }
}
