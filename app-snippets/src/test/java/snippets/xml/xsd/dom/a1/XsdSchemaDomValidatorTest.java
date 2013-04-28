package snippets.xml.xsd.dom.a1;

import static org.junit.Assert.assertTrue;

import java.io.File;



import org.junit.Test;

public class XsdSchemaDomValidatorTest {
    @Test
    public void testByFile() {
        String xmlPath = this.getClass().getResource("tree.xml").getFile();
        String xsdPath = this.getClass().getResource("tree.xsd").getFile();
        
        File xmlFile = new File(xmlPath); 
        File xsdFile = new File(xsdPath);
        
        boolean actual = XsdSchemaDomValidator.validateXml(xmlFile, xsdFile);
        System.out.println(actual);
        assertTrue(actual);        
    }
    
    @Test
    public void testByString() {
        String xmlStr =     String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s",  
                                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
                                "<root>",    
                                    "<node1 name=\"Folder 1\">",
                                        "<node1 name=\"Folder 2\">",
                                            "<node1 name=\"Folder 3\">",
                                                "<node1 name=\"Folder 4\">",
                                                    "<node1 name=\"Folder 5\">",
                                                    "</node1>",
                                                "</node1>",
                                            "</node1>",
                                        "</node1>",
                                    "</node1>",
                                "</root>"
                            );
        
        String xsdStr =     String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",  
                                "<?xml version=\"1.0\" encoding=\"utf-8\"?>",
                                "<xs:schema elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">",
                                    "<xs:element name=\"root\">",
                                        "<xs:complexType>",
                                            "<xs:sequence>",
                                                "<xs:element name=\"node1\" type=\"node1Type\" />",
                                            "</xs:sequence>",
                                            "<xs:attribute name=\"name\" type=\"xs:string\" />",
                                        "</xs:complexType>",
                                    "</xs:element>",                        
                                    "<xs:complexType name=\"node1Type\">",
                                        "<xs:sequence>",
                                            "<xs:element minOccurs=\"0\" maxOccurs=\"1\" name=\"node1\" type=\"node1Type\" />",
                                        "</xs:sequence>",
                                        "<xs:attribute name=\"name\" type=\"xs:string\" />",
                                    "</xs:complexType>",
                                "</xs:schema>"
                            );
        
        boolean actual = XsdSchemaDomValidator.validateXml(xmlStr, xsdStr);
        System.out.println(actual);
        assertTrue(actual);  
    }
}
