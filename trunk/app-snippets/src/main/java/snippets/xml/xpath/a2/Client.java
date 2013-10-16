package snippets.xml.xpath.a2;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Client {
    public static NodeList extract(Document doc, String path) throws XPathExpressionException {        
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList)xPath.evaluate(path, doc.getDocumentElement(), XPathConstants.NODESET);
        
        return nodes;
    }    
    
    
}
