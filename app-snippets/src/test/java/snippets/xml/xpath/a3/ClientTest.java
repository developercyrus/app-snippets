package snippets.xml.xpath.a3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ClientTest {
    @Test
    public void test1() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        String path = this.getClass().getResource("WSJ_0098.xml").getFile();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path), "utf-8");
        BufferedReader br = new BufferedReader (isr); 
        InputSource is = new InputSource(br);
        
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(is);
        
        int expected = 19;
        int actual = Client.extract(doc, "count(/DOC/S1)");
        
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
