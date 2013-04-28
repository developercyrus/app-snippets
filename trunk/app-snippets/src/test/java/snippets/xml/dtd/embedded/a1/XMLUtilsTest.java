package snippets.xml.dtd.embedded.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XMLUtilsTest {
    @Test
    public void test1() throws IOException, ParserConfigurationException, SAXException {
        String path = this.getClass().getResource("topic.xml").getFile();       
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        boolean actualDOM = XMLUtils.validateWithDTDUsingDOM(xmlStr);
        boolean actualSAX = XMLUtils.validateWithDTDUsingSAX(xmlStr);
        
        assertEquals(true, actualDOM);
        assertEquals(true, actualSAX);
    }
    
    @Test
    public void test2() throws IOException, ParserConfigurationException, SAXException {
        String path = this.getClass().getResource("topic2.xml").getFile();       
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        boolean actualDOM = XMLUtils.validateWithDTDUsingDOM(xmlStr);
        boolean actualSAX = XMLUtils.validateWithDTDUsingSAX(xmlStr);
        
        assertEquals(true, actualDOM);
        assertEquals(true, actualSAX);
    }
}
