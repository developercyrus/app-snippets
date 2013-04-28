package snippets.html.parser.jsoup.a2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleCodeCheckIn {
    public static void main(String[] args) throws MalformedURLException, IOException {
        String url = "http://code.google.com/p/app-snippets/source/list";
        Document doc = Jsoup.parse(new URL(url), 60000);
        Elements elements = doc.select(".id");
        Element e = elements.get(0);
        System.out.println(e.text().substring(1, e.text().length()));
    }

}
