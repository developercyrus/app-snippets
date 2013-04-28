package snippets.html.parser.jsoup.a1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head><body><div id='content'>Parsed HTML into a doc.</div></body></html>";
        Document doc = Jsoup.parse(html);
        Elements e = doc.select("#content");
        System.out.println(e.html());   
        
        String html2 = "<td align='left' class='patFuncStatus'> DUE 23-02-11  <span class='patFuncRenewCount'>Renewed 2 times</span></td>";
        Document doc2 = Jsoup.parse(html2);
        Elements elements = doc2.select(".patFuncStatus");
        for (Element e2 : elements) {
            System.out.println(e2.ownText());
        }
        
        String s = "QA76.9.D26 S38 2009 c.2";
        int end;
        if ((end=s.indexOf("c."))!=-1) {
            s = s.substring(0, end).trim();
            System.out.println(s);
        }
        
        String str = "DUE 15-03-11 +1 HOLD";
        System.out.println(str.substring(0, 12));
    }
}
