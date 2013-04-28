package snippets.xml.dtd.external.a1;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

public class Demo {
    public static String validate(String xmlStr, String dtdPath) throws SAXException, TransformerException  {
        Source xmlInput = new StreamSource(new StringReader(xmlStr));
        StreamResult xmlOutput = new StreamResult(new StringWriter());
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, dtdPath);
        transformer.transform(xmlInput, xmlOutput);
        
        return xmlOutput.getWriter().toString().trim();
    }    
}
