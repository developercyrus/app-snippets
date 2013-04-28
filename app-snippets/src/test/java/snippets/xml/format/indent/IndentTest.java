package snippets.xml.format.indent;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.custommonkey.xmlunit.Diff;
import org.junit.Test;
import org.xml.sax.SAXException;

public class IndentTest {
    @Test
    public void test() throws TransformerException, SAXException, IOException {
        String xmlStr = "<a><b>1</b></a>";
        String expected =   String.format("%s\n%s\n%s\n%s",
                                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
                                "<a>",
                                "  <b>1</b>",
                                "</a>"
                            );
        String actual = Indent.format(xmlStr);
        System.out.println(actual);
        
        Diff diff = new Diff(expected, actual);  
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
}
