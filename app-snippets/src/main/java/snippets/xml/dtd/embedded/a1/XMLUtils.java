package snippets.xml.dtd.embedded.a1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
//DOM
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//SAX
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.InputSource;

public class XMLUtils {
    // validate using DOM (DTD as defined in the XML)
    public static boolean validateWithDTDUsingDOM(String xmlStr) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(
            new ErrorHandler() {
                public void warning(SAXParseException e) throws SAXException {
                    System.out.println("WARNING : " + e.getMessage()); // do nothing
                }

                public void error(SAXParseException e) throws SAXException {
                    System.out.println("ERROR : " + e.getMessage());
                    throw e;
                }

                public void fatalError(SAXParseException e) throws SAXException {
                    System.out.println("FATAL : " + e.getMessage());
                    throw e;
                }
            }
        );
        InputStream is = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
        builder.parse(new InputSource(is));
        return true;
    }


    // validate using SAX (DTD as defined in the XML)
    public static boolean validateWithDTDUsingSAX(String xmlStr) throws ParserConfigurationException, IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        SAXParser parser = factory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setErrorHandler(
            new ErrorHandler() {
                public void warning(SAXParseException e) throws SAXException {
                    System.out.println("WARNING : " + e.getMessage()); // do nothing
                }

                public void error(SAXParseException e) throws SAXException {
                    System.out.println("ERROR : " + e.getMessage());
                    throw e;
                }

                public void fatalError(SAXParseException e) throws SAXException {
                    System.out.println("FATAL : " + e.getMessage());
                    throw e;
                }
            }
        );
        InputStream is = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
        reader.parse(new InputSource(is));
        return true;
    }

    public static void main (String args[]) throws Exception{ 
        System.out.println(XMLUtils.validateWithDTDUsingDOM("c:/temp/howto.xml"));
        System.out.println(XMLUtils.validateWithDTDUsingSAX("c:/temp/howto.xml"));       
    }
}
