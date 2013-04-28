package snippets.xml.serialize.xstream.a1;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ChangerTest {
    @Test
    public void testToXml() throws SAXException, IOException {
        Changer changer = new Changer();
        Person d = new Person();
        d.setFirstname("peter");
        d.setAge(30);
        d.setPhone(new Phone("Nexus", 12345678));
        String actual = changer.toXML(d);

        String expected =   String.format("%s%s%s%s%s%s%s%s", 
                                "<person>",
                                    "<firstname>peter</firstname>",
                                    "<age>30</age>",
                                    "<phone>",
                                        "<model>Nexus</model>",
                                        "<number>12345678</number>",
                                    "</phone>",
                                "</person>"
                            );  
        
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
    
    @Test
    public void testFromXml() {
        Changer changer = new Changer();        
        String xml =    String.format("%s%s%s%s%s%s%s%s", 
                            "<person>",
                                "<firstname>peter</firstname>",
                                "<age>30</age>",
                                "<phone>",
                                    "<model>Nexus</model>",
                                    "<number>12345678</number>",
                                "</phone>",
                            "</person>"
                        );  

        Person actualPerson = changer.fromXML(xml);
        Phone actualPhone = actualPerson.getPhone();
        
        assertEquals("peter", actualPerson.getFirstname());
        assertEquals(30, actualPerson.getAge());
        assertEquals("Nexus", actualPhone.getModel());
        assertEquals(12345678, actualPhone.getNumber());
    }
}
