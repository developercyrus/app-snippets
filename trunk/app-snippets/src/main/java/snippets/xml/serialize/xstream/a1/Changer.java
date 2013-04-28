package snippets.xml.serialize.xstream.a1;

import com.thoughtworks.xstream.XStream;

public class Changer {
    private XStream xstream;
    
    public Changer() {
        xstream = new XStream();
    }
    
    public String toXML(Person p) {
        xstream.alias("person", Person.class);
        String xml = xstream.toXML(p);
        return xml;
    }
    
    public Person fromXML(String xml) {
        xstream.alias("person", Person.class);
        Person p = (Person)xstream.fromXML(xml);
        return p;
    }
}
