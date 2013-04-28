package snippets.xml.serialize.xmlencoder.a1;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

public class ChangerTest {    
    @Test
    public void testToXml() throws IOException, SAXException {        
        String path = this.getClass().getResource("peter.xml").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, expected = new String();
        while ((line = br.readLine()) != null) {
            expected = expected + line;
        }
        
        Person p = new Person();
        p.setFirstName("Peter");
        p.setMale(true);
        List<String> phones = new ArrayList<String>();
        phones.add("iphone");
        phones.add("android");
        p.setPhones(phones);
        
        Changer c = new Changer();
        String actual = c.toXML(p);

        expected = expected.replaceAll("java version=\"[0-9].[0-9].[0-9]_[0-9]*\"", "java version=\"\"");
        actual = actual.replaceAll("java version=\"[0-9].[0-9].[0-9]_[0-9]*\"", "java version=\"\"");
        
        
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        System.out.println(actual);
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
    
    @Test
    public void testFromXml() throws IOException {        
        String path = this.getClass().getResource("mary.xml").getFile();       
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xml = new String();
        while ((line = br.readLine()) != null) {
            xml = xml + line;
        }

        Changer c = new Changer();
        Person actual = c.fromXML(xml);
        assertEquals("Mary", actual.getFirstName());
        assertEquals(false, actual.isMale());
        assertEquals("nokia", actual.getPhones().get(0));        
        assertEquals("blackberry", actual.getPhones().get(1));
    }
}
