package snippets.xml.xpath.a3;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Client {
    public static int extract(Document doc, String path) throws XPathExpressionException {        
        XPath xPath = XPathFactory.newInstance().newXPath();
        int count = ((Double)xPath.evaluate(path, doc.getDocumentElement(), XPathConstants.NUMBER)).intValue();
        return count;
    }    
    
    
}
