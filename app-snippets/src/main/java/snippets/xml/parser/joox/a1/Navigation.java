package snippets.xml.parser.joox.a1;

import static org.joox.JOOX.$;

import java.io.IOException;
import java.io.StringReader;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Navigation {
    public static String extract(String xmlStr) throws SAXException, IOException {
        InputSource source = new InputSource(new StringReader(xmlStr));
        Document document = $(source).document();
        
        return $(document).find("book").attr("id", "1").find("name").text();
    }
}
