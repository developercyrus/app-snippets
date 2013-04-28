package snippets.xml.serialize.xmlencoder.a1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Changer {
    public String toXML(Person p) {
        OutputStream os = new ByteArrayOutputStream();  
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(os));
        encoder.writeObject(p);
        encoder.close();
        
        return os.toString();
    }
    
    public Person fromXML(String xml) throws UnsupportedEncodingException {
        InputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(is));        
        Person person = (Person)decoder.readObject();
        decoder.close();
        
        return person;
    }
}
