package snippets.xml.xsl.a1;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransformer {
    public static String transform(String xmlStr, String xslStr) throws TransformerException {
        StringReader xml = new StringReader(xmlStr);
        StringReader xsl = new StringReader(xslStr);
        StringWriter transformed = new StringWriter();

        TransformerFactory f = TransformerFactory.newInstance();
        Transformer t = f.newTransformer(new StreamSource(xsl));
        Source s = new StreamSource(xml);
        Result r = new StreamResult(transformed);
        t.transform(s,r);
        return transformed.toString();
    }
    
    public static String transform(File xmlFile, File xslFile) throws TransformerException {
        StringWriter transformed = new StringWriter();
        
        TransformerFactory f = TransformerFactory.newInstance();
        Transformer t = f.newTransformer(new StreamSource(xslFile));
        Source s = new StreamSource(xmlFile);
        Result r = new StreamResult(transformed);
        t.transform(s,r);
        return transformed.toString();
    }
}
