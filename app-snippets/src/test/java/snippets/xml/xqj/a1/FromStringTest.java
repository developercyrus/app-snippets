package snippets.xml.xqj.a1;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xquery.XQException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

public class FromStringTest {
    @Test
    public void selectTest() throws IOException, XQException, ParserConfigurationException, SAXException{
        String xmlPath = this.getClass().getResource("doc.xml").getFile();
        String xqjPath = this.getClass().getResource("query.xqj").getFile();
        String expectedPath = this.getClass().getResource("expected.xml").getFile();
                
        String line = "";
        String xmlStr  = "";
        String xqjStr  = "";
        String expected = "";
        String actual = "";
        BufferedReader br = new BufferedReader(new FileReader(xmlPath));       
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        br = new BufferedReader(new FileReader(xqjPath));       
        while ((line = br.readLine()) != null) {
            xqjStr = xqjStr + line;
        }
        br = new BufferedReader(new FileReader(expectedPath));       
        while ((line = br.readLine()) != null) {
            expected = expected + line;
        }
        
        
        String[] results = FromString.select(xmlStr, xqjStr);
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<results.length; i++) {
            sb.append(results[i]);
        }
        
        actual = wrap(sb.toString());
        expected = wrap(expected);
        
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        System.out.println(xmlPath);
        System.out.println(actual);
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
    
    public static String wrap(String str) {
        return "<root>" + str + "</root>";
    }
}
