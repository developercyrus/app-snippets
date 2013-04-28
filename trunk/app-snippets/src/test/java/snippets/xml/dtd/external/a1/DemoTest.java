package snippets.xml.dtd.external.a1;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

import snippets.xml.dtd.external.a1.Demo;

public class DemoTest {
    @Test
    public void test() throws SAXException, IOException, TransformerException  {
        String xmlPath = this.getClass().getResource("family.xml").getFile();
        String dtdPath = this.getClass().getResource("family.dtd").getFile();
        String expectedPath = this.getClass().getResource("expected.xml").getFile();
                    
        String line = "";
        String expected = "";
        String xmlStr = "";
        
        BufferedReader br = new BufferedReader(new FileReader(xmlPath));        
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }   
        br = new BufferedReader(new FileReader(expectedPath));       
        while ((line = br.readLine()) != null) {
            expected = expected + line;
        }
        
        String actual = Demo.validate(xmlStr, dtdPath);
        
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
}
