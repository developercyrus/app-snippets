package snippets.html.parser.jsoup.a3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class XmlExtractor {
    public static StringBuilder fetchXmlContent(String url) throws IOException {
        StringBuilder xmlContent = new StringBuilder();
        Document document = Jsoup.connect(url).timeout(300000).get();
        xmlContent.append(document.body().html());
        return xmlContent;
    }

    public static void saveXmlFile(StringBuilder xmlContent, String saveLocation) throws IOException {
        FileWriter fileWriter = new FileWriter(saveLocation);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(xmlContent.toString());
        bufferedWriter.close();
        System.out.println("Downloading completed successfully..!");
    }

    public static void downloadXml(String url, String saveLocation) throws IOException {
        XmlExtractor.saveXmlFile(XmlExtractor.fetchXmlContent(url), saveLocation);
    }
}
