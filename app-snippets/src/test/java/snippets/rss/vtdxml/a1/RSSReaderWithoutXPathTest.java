package snippets.rss.vtdxml.a1;

import org.junit.Test;

public class RSSReaderWithoutXPathTest {
    @Test
    public void test() throws Throwable {
        String path = this.getClass().getResource("servers.xml").getFile();
        RSSReaderWithoutXPath.parse(path);
    }
}
