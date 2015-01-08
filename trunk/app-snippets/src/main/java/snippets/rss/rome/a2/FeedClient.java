package snippets.rss.rome.a2;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class FeedClient {
    public static void main(String[] args) throws IOException, IllegalArgumentException, FeedException {
        URL url  = new URL("http://earthquake.usgs.gov/earthquakes/catalogs/7day-M2.5.xml");
        XmlReader reader = null;

        try {

            reader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(reader);
            for (Iterator<?> i = feed.getEntries().iterator(); i.hasNext();) {
                SyndEntry entry = (SyndEntry) i.next();
                System.out.println(entry.getUpdatedDate());
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

}