package snippets.jdk.jaxb.nested.a1;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

public class Object2XmlTest {
    
    @Test
    public void test() throws JAXBException, IOException, SAXException {
        Field field = new Field(1);
        field.setScope("InternalUse");
        field.setFolderFieldID(1);

        Locale locale1 = new Locale(1);
        locale1.setDescription("My Custom Multiple Choice");
        locale1.setName("MC");
        locale1.setHeader("");

        Locale locale2 = new Locale(2);
        locale2.setDescription("我的自選多項選擇");
        locale2.setName("多項選擇");
        locale2.setHeader("");

        List<Locale> locales = new ArrayList<Locale>();
        locales.add(locale1);
        locales.add(locale2);

        field.setLocale(locales);

        Writer w = new StringWriter();
        JAXBContext c = JAXBContext.newInstance(Field.class);
        c.createMarshaller().marshal(field, w); 
        String actual = w.toString();
        
        
        String expectedPath = this.getClass().getResource("expected.xml").getFile();        
        String line, expected = "";
        BufferedReader br = new BufferedReader(new FileReader(expectedPath));       
        while ((line = br.readLine()) != null) {
            expected = expected + line;
        }
        
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
}
