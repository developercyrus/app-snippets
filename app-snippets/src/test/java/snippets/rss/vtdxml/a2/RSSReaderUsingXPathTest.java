package snippets.rss.vtdxml.a2;

import org.junit.Test;

public class RSSReaderUsingXPathTest {
    @Test
    public void test() throws Throwable {
        String path = this.getClass().getResource("servers.xml").getFile();
        RSSReaderUsingXPath.parse(path);
    }
}
