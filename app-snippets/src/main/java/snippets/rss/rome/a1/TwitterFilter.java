package snippets.rss.rome.a1;

import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.SyndFeedOutput;
import com.sun.syndication.io.XmlReader;

public class TwitterFilter {
    public static String convert(String xmlStr) throws Throwable {
        // outFeed
        SyndFeed outFeed = new SyndFeedImpl();
        outFeed.setFeedType("atom_1.0");
        outFeed.setTitle("Filtered Twitter Feed");
        outFeed.setDescription("Filtered Twitter Feed");
        outFeed.setAuthor("developer.cyrus");
        outFeed.setLink("http://url-services.appspot.com");

        List<SyndEntry> outEntries = new ArrayList<SyndEntry>();
        outFeed.setEntries(outEntries);
                
        // inFeed
        InputStream is = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
        SyndFeedInput input = new SyndFeedInput();        
        SyndFeed inFeed = input.build(new XmlReader(is, "UTF-8"));
        
        List<SyndEntry> inEntries = inFeed.getEntries();
        for(SyndEntry inEntry : inEntries) {
            if ( (inEntry.getTitle().indexOf("http://"))!= -1 ) {
                outEntries.add(inEntry);
            }
        }

        SyndFeedOutput output = new SyndFeedOutput();
        OutputStream os = new ByteArrayOutputStream();  
        output.output(outFeed, new PrintWriter(os));
        
        return os.toString();
    }

}

