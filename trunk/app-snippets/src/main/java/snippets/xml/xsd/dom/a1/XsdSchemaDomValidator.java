package snippets.xml.xsd.dom.a1;

import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.validation.Validator;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.StringReader;

public class XsdSchemaDomValidator {    
    
    public static boolean validateXml(File xmlFile, File xsdFile) {
        Schema schema = loadSchema(xsdFile);
        Document document = parseXmlDom(xmlFile);
        
        try {
            Validator validator = schema.newValidator();
            System.out.println("Validator Class: " + validator.getClass().getName());

            validator.validate(new DOMSource(document));   
            System.out.println("passed");
            return true;
        } catch (Exception e) {            
            e.printStackTrace();
            System.out.println("failed");
            return false;
        }
    }

    public static Schema loadSchema(File xsdFile) {
        Schema schema = null;
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(xsdFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schema;
    }
    
    public static Document parseXmlDom(File xmlFile) {
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
    
    public static boolean validateXml(String xmlStr, String xsdStr) {
        Schema schema = loadSchema(xsdStr);
        Document document = parseXmlDom(xmlStr);
        
        try {
            Validator validator = schema.newValidator();
            System.out.println("Validator Class: " + validator.getClass().getName());

            validator.validate(new DOMSource(document));   
            System.out.println("passed");
            return true;
        } catch (Exception e) {            
            e.printStackTrace();
            System.out.println("failed");
            return false;
        }
    }
    
    public static Schema loadSchema(String xsdStr) {
        Schema schema = null;
        try {
            StringReader xsd = new StringReader(xsdStr);
            Source source = new StreamSource(xsd);
            
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);        
            schema = factory.newSchema(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schema;
    }
    
    public static Document parseXmlDom(String xmlStr) {
        Document document = null;
        try {
            StringReader xml = new StringReader(xmlStr);
            InputSource source = new InputSource(xml);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

}
