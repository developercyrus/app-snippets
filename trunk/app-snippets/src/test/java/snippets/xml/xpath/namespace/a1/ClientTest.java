package snippets.xml.xpath.namespace.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;

public class ClientTest {
    @Test
    public void test1() throws IOException, XPathExpressionException {
        String path = this.getClass().getResource("7day-M2.5.xml").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        String expected = "2013-06-28T03:52:39Z";
        String actual = Client.extract(xmlStr, "/:feed/:entry/:updated[1]").trim();
        
        System.out.println(actual);
        assertEquals(expected, actual);
    }   
    
    @Test
    public void test2() throws IOException, XPathExpressionException {
        String path = this.getClass().getResource("7day-M2.5.xml").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        String expected = "36.7567 -121.4702";
        String actual = Client.extract(xmlStr, "/:feed/:entry/georss:point[1]").trim();
        
        System.out.println(actual);
        assertEquals(expected, actual);
    }  
}
