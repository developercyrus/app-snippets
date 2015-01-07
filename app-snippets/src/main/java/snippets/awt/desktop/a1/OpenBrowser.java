package snippets.awt.desktop.a1;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;

public class OpenBrowser {
    public static void main(String[] args) throws Exception {
        String[][] urls =   { 
                                { "http://www.google.com/search?q=", "UTF-8" },
                                { "http://www.bing.com/search?q=", "UTF-8" },
                             };
        Desktop desktop = Desktop.getDesktop();
        for (String[] urlStr : urls) {
            String queryStr = URLEncoder.encode("trf", urlStr[1]);
            URI uri = new URI(urlStr[0] + queryStr);
            desktop.browse(uri);
        }
    }
}