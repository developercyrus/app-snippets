package snippets.xml.xqj.a1;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQConstants;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.sf.saxon.xqj.SaxonXQDataSource;

public class FromString {
    public static String[] select(String xmlStr, String xQuery) throws XQException, ParserConfigurationException, SAXException, IOException {           
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
        
        XQDataSource ds = new SaxonXQDataSource();
        XQConnection conn = ds.getConnection(); 
        XQPreparedExpression exp =  conn.prepareExpression(xQuery); 
        exp.bindNode(XQConstants.CONTEXT_ITEM, doc, null);
        XQResultSequence rs = exp.executeQuery(); 

        List<String> list = new ArrayList<String>();
        while (rs.next()) {
            String tmp = rs.getItemAsString(null);
            list.add(tmp);            
        }
        String[] results = new String[list.size()];
        results = list.toArray(results);
        
        return results;
    } 
}

