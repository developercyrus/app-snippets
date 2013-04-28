package snippets.xml.xpath.a1;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class Client {
    public static String extract(String xmlStr, String path) throws XPathExpressionException {
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        InputSource source = new InputSource(new StringReader(xmlStr));
        String extracted = xpath.evaluate(path, source);

        return extracted;
    }    
}
