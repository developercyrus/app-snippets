package snippets.xml.parser.dom.a1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Client {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        //demo1();
        //demo2();
        demo3();
        
    }
    
    public static void demo1() throws ParserConfigurationException, SAXException, IOException {
        String path = Client.class.getResource("document.xml").getFile();
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File(path));

        doSomething(document.getDocumentElement());
    }
    
    public static void demo2() throws ParserConfigurationException, SAXException, IOException {
        String path = Client.class.getResource("WSJ_0098.xml").getFile();
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File(path));

        
        NodeList nodeList = null;
        Node node = null;
        
        nodeList = document.getElementsByTagName("DOC");
        node = nodeList.item(0);
        System.out.println(node.getAttributes().getNamedItem("fileId").getNodeValue());
        System.out.println(node.getAttributes().getNamedItem("sectionId").getNodeValue());
        
        nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                //doSomething2(currentNode, "/DOC");
                //doSomething3(currentNode, "/DOC");
                //doSomething4(currentNode, "/0");
            }
        }
    }
    
    public static void demo3() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        String path = Client.class.getResource("WSJ_0098.xml").getFile();
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File(path));

        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList)xPath.evaluate("/DOC/S1[@sentenceId='16']//*[@id='26']", document.getDocumentElement(), XPathConstants.NODESET);
        System.out.println("word="+nodes.item(0).getTextContent());
        getParent(nodes.item(0), 1);
        
    }
    
    public static void doSomething(Node node) {        
        System.out.println(node.getNodeName());
        
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                doSomething(currentNode);
            }
        }
    }
    
    public static void doSomething2(Node node, String xPath) {
        if (node.getNodeName().equals("S1")) {
            System.out.println(node.getAttributes().getNamedItem("sentenceId").getNodeValue());
        }
        
        String nodeName = node.getNodeName();
        
        
        
        NodeList nodeList = node.getChildNodes();
        int n = nodeList.getLength();
        if (n == 1) {
            System.out.println(
                    nodeName 
                    + " " + node.getAttributes().getNamedItem("id").getNodeValue() 
                    + " " + node.getAttributes().getNamedItem("pid").getNodeValue()
                    + " " + node.getAttributes().getNamedItem("level").getNodeValue()
                    + " " + xPath + "/" + nodeName 
                    + " " + node.getTextContent().trim()                    
            );
        }
        else {
            System.out.println(
                    nodeName 
                    + " " + node.getAttributes().getNamedItem("id").getNodeValue() 
                    + " " + node.getAttributes().getNamedItem("pid").getNodeValue()
                    + " " + node.getAttributes().getNamedItem("level").getNodeValue()
                    + " " + xPath + "/" + nodeName 
            );
        }

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                doSomething2(currentNode, xPath + "/" + nodeName);
            }
        }
    }
    
    public static void doSomething3(Node node, String xPath) {
        if (node.getNodeName().equals("S1")) {
            System.out.println(node.getAttributes().getNamedItem("sentenceId").getNodeValue());
        }
        
        String nodeName = node.getNodeName();
        
        NodeList nodeList = node.getChildNodes();
        int n = nodeList.getLength();
        
        System.out.println(
                "S.N.query('"
                + xPath + "/" + nodeName 
                + "')"                 
        );
 
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                doSomething3(currentNode, xPath + "/" + nodeName);
            }
        }
    }
    
    public static void doSomething4(Node node, String xPathId) {
        if (node.getNodeName().equals("S1")) {
            System.out.println(node.getAttributes().getNamedItem("sentenceId").getNodeValue());
        }
        
        String nodeName = node.getNodeName();
        
        NodeList nodeList = node.getChildNodes();
        int n = nodeList.getLength();
        
        System.out.println(
                xPathId + "/" + node.getAttributes().getNamedItem("id").getNodeValue()          
        );
 
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                doSomething4(currentNode, xPathId + "/" + node.getAttributes().getNamedItem("id").getNodeValue());
            }
        }
    }
    
    public static void getParent(Node node, int height) {                        
        Node p = node.getParentNode();
        if (p.getAttributes().getNamedItem("id") != null) {
            System.out.println(p.getAttributes().getNamedItem("id").getNodeValue() + " " + height);
            getParent(p, height+1);
        }
    }
}