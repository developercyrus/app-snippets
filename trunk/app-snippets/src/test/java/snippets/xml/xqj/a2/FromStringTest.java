package snippets.xml.xqj.a2;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xquery.XQException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class FromStringTest {
    @Test
    public void selectTest() throws IOException, XQException, ParserConfigurationException, SAXException{
        String xmlPath = this.getClass().getResource("dept_collection.xml").getFile();
        String xqjPath = this.getClass().getResource("countQuery.xqj").getFile();
       
        String line = "";
        String xmlStr  = "";
        String xqjStr  = "";
        BufferedReader br = new BufferedReader(new FileReader(xmlPath));       
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        br = new BufferedReader(new FileReader(xqjPath));       
        while ((line = br.readLine()) != null) {
            xqjStr = xqjStr + line;
        }
        
        xqjStr = xqjStr.replaceAll("@path", xmlPath);
        int[] actual = FromString.count(xmlStr, xqjStr);
        int[] expected = {3};
        
        assertArrayEquals(actual, expected);
    }
}
