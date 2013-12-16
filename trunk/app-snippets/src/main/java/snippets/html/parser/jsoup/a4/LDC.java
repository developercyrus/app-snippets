package snippets.html.parser.jsoup.a4;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class LDC {

    public static void main(String[] args) throws IOException {
        LDC ldc = new LDC();
        ldc.go();
    }
    
    public void go() throws IOException {    	
        Document doc = Jsoup.parse(new URL("http://catalog.ldc.upenn.edu/byyear.jsp"), 60000);
        Elements links = doc.select("table#catalogyearlist > tbody > tr > td > a");
        
        for (int i=0; i<links.size(); i++) {
            String link = links.get(i).attr("href");
            Document page = Jsoup.parse(new URL("http://catalog.ldc.upenn.edu/" + link), 60000);
            String price = page.select("div.section > table > tbody > tr:contains(Non-member Fee)").text();
            String title = page.select("div.section > h1").text();
            if (price.contains("$0")) {                
                System.out.println("http://catalog.ldc.upenn.edu/" + link + "\t" + title);            
                //System.out.println(price);   
            }
        }  
    }
    
}

