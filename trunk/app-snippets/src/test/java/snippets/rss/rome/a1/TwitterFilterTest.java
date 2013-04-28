package snippets.rss.rome.a1;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;

public class TwitterFilterTest {
    @Test
    public void test() throws Throwable {
        String xmlPath = this.getClass().getResource("tweet.xml").getFile();
        String expectedPath = this.getClass().getResource("expected.xml").getFile();
        
        BufferedReader br = new BufferedReader(new FileReader(xmlPath));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        br = new BufferedReader(new FileReader(expectedPath));
        String expected = new String();
        while ((line = br.readLine()) != null) {
            expected = expected + line;
        }
        
        String actual = TwitterFilter.convert(xmlStr).trim();

        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        //System.out.println(actual);
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
}
