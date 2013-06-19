package snippets.xml.xpath.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;

public class ClientTest {
    @Test
    public void test1() throws IOException, XPathExpressionException {
        String path = this.getClass().getResource("iciba.success.xml").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        String expected = "succeed";
        String actual = Client.extract(xmlStr, "/dict/key").trim();
        
        System.out.println(actual);
        assertEquals(expected, actual);
    }
    
    @Test
    public void test2() throws IOException, XPathExpressionException {
        String path = this.getClass().getResource("iciba.success.xml").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        String expected = "May God strengthen our hands for the good work ahead-and always, always bless our America.";
        String actual = Client.extract(xmlStr, "/dict/sent[4]/orig").trim();
        
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
