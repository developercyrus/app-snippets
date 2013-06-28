package snippets.xml.xpath.namespace.a1;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class Client {
    public static String extract(String xmlStr, String path) throws XPathExpressionException {
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        nsContext.addNamespace("", "http://www.w3.org/2005/Atom");
        nsContext.addNamespace("georss", "http://www.georss.org/georss");
        
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        xpath.setNamespaceContext(nsContext);
        
        InputSource source = new InputSource(new StringReader(xmlStr));
        String extracted = xpath.evaluate(path, source);

        return extracted;
    }    
}
