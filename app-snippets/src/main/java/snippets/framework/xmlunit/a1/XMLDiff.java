package snippets.framework.xmlunit.a1;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.SAXException;

public class XMLDiff {
    public static void main(String[] args) throws SAXException, IOException {
        URL url1a = XMLDiff.class.getResource("xml1.xml");
        URL url1b = XMLDiff.class.getResource("xml1.xml");
        URL url2 = XMLDiff.class.getResource("xml2.xml");
        URL url3 = XMLDiff.class.getResource("xml3.xml");
        
        FileReader xml1a = new FileReader(url1a.getPath());
        FileReader xml1b = new FileReader(url1b.getPath());
        FileReader xml2 = new FileReader(url2.getPath());
        FileReader xml3 = new FileReader(url3.getPath());
        
        XMLUnit.setIgnoreWhitespace(true);
        Diff diff1 = new Diff(xml1a, xml2);
        Diff diff2 = new Diff(xml1b, xml3);
        
        System.out.println("diff1: element position swapped: similar: " + diff1.similar());
        System.out.println("diff1: element position swapped: identical: " + diff1.identical());
        System.out.println("diff2: no white space: similar: " + diff2.similar());
        System.out.println("diff2: no white space: identical: " +  diff2.identical());        
    } 
}
