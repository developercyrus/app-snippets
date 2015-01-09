package snippets.html.parser.htmlcleaner.a3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, IOException, XPatherException {
        TagNode nodes = new HtmlCleaner().clean(new URL("http://code.google.com/p/app-snippets/source/list"));

        Object[] ns = nodes.evaluateXPath("//td[@class='id']");
        for(Object o : ns) {  
            TagNode n = (TagNode) o;  
            System.out.println(n.getText());  
        }  
    }
}
