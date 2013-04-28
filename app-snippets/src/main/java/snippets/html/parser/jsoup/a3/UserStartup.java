package snippets.html.parser.jsoup.a3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class UserStartup {
	public static void main(String args[]) throws IOException {
		UserStartup u = new UserStartup();
		u.go();
	}
	
    public void go() throws IOException {    	
    	String resultPath = "/src/main/output/snippets/html/parser/jsoup/a3";
    	String projectPath = new File("").getAbsolutePath();
    	
    	String path = this.getClass().getResource("startup.txt").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, html = new String();
        while ((line = br.readLine()) != null) {
            html = html + line;
        }

        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("option");
        Element e;
        for (int i=0; i<elements.size(); i++) {
        	e = elements.get(i);
            int pos = e.text().indexOf("創業通");
            if (pos != -1) {
            	String url = "http://www.ecjob.com.hk/user/user_startup.php?article_id=" + e.attr("value");
            	String saveLocation = projectPath + "/" + resultPath + "/" + e.attr("value") + ".html";
                System.out.println(e.text() + " " + url);
                XmlExtractor.downloadXml(url, saveLocation); 
            }
        }
    }
    
}

