package snippets.html.parser.htmlcleaner.a1;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class Main {
    public static void main(String[] args) throws Exception {  
        String htmlStr = "<html><head><title>First parse</title></head><body><div id='content'>Parsed HTML into a doc.</div></body></html>";
        
        HtmlCleaner cleaner = new HtmlCleaner();  
        TagNode node = cleaner.clean(htmlStr);  
        Object[] ns = node.evaluateXPath("//div[@id='content']");
        for(Object on : ns) {  
            TagNode n = (TagNode) on;  
            System.out.println(n.getText());  
        }          
    }  
}
