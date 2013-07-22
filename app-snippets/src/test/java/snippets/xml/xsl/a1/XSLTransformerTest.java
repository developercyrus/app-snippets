package snippets.xml.xsl.a1;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.xml.sax.SAXException;

public class XSLTransformerTest {
    @Test
    public void testbyString() throws TransformerException, SAXException, IOException {
        String xmlStr =     String.format("%s%s%s%s%s",  
                                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>", 
                                "<resume>",
                                    "<field1>Cyrus</field1>",
                                    "<field2>Pam</field2>",
                                "</resume>"
                            );
        String xslStr =     String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                                "<?xml version=\"1.0\"?>", 
                                "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">",  
                                "<xsl:template match=\"resume\">", 
                                    "<html>", 
                                        "<body>",  
                                            "<table border=\"1\">",   
                                                "<tr>", 
                                                    "<td>First Name</td>",  
                                                    "<td><xsl:value-of select=\"field1\"/></td>",                          
                                                "</tr>", 
                                                "<tr>", 
                                                    "<td>Last Name</td>",  
                                                    "<td><xsl:value-of select=\"field2\"/></td>",                          
                                                "</tr>", 
                                            "</table>",     
                                        "</body>",
                                    "</html>", 
                                "</xsl:template>", 
                                "</xsl:stylesheet>"
                            );
        
        String actual = XSLTransformer.transform(xmlStr, xslStr);
        String expected =   String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s",                              
                                "<html>",
                                    "<body>",
                                        "<table border=\"1\">",
                                            "<tr>",
                                                "<td>First Name</td>",
                                                "<td>Cyrus</td>",
                                            "</tr>",
                                            "<tr>",
                                                "<td>Last Name</td>",
                                                "<td>Pam</td>",
                                            "</tr>",
                                        "</table>",
                                    "</body>",
                                "</html>"
                            );

        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
    
    @Test
    public void testbyFile() throws TransformerException, SAXException, IOException {
        String xmlPath = this.getClass().getResource("doc.xml").getFile();
        String xslPath = this.getClass().getResource("doc.xsl").getFile();
        String htmPath = this.getClass().getResource("doc.htm").getFile();
        
        File xmlFile = new File(xmlPath); 
        File xslFile = new File(xslPath);
        File htmFile = new File(htmPath);
        
        
        BufferedReader br = new BufferedReader(new FileReader(htmFile));
        String line, expected = new String();
        while ((line = br.readLine()) != null) {
            expected = expected + line;
        }
        
        String actual = XSLTransformer.transform(xmlFile, xslFile);
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff = new Diff(expected, actual);  
        assertTrue(diff.similar());
        assertXMLEqual(expected, actual);
    }
}
