package snippets.jdk.lang.string.format.a1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AtomFormattertTest {

    @Test
    public void test3Args() {
        String template = "<?xml version=\"1.0\"?> <entry xmlns=\"http://www.w3.org/2005/Atom\" xmlns:media=\"http://search.yahoo.com/mrss/\" xmlns:yt=\"http://gdata.youtube.com/schemas/2007\"> <media:group> <media:title type=\"plain\">%s</media:title> <media:description type=\"plain\">%s</media:description> <media:category scheme=\"http://gdata.youtube.com/schemas/2007/categories.cat\">%s</media:category> </media:group> </entry>";
        String expectedTemplate = "<?xml version=\"1.0\"?> <entry xmlns=\"http://www.w3.org/2005/Atom\" xmlns:media=\"http://search.yahoo.com/mrss/\" xmlns:yt=\"http://gdata.youtube.com/schemas/2007\"> <media:group> <media:title type=\"plain\">Feed 1</media:title> <media:description type=\"plain\">This is a Hello World</media:description> <media:category scheme=\"http://gdata.youtube.com/schemas/2007/categories.cat\">fun</media:category> </media:group> </entry>";
        String title = "Feed 1";
        String description = "This is a Hello World";
        String category = "fun";
        
        assertEquals(expectedTemplate, AtomFormatter.getData(template, title, description, category));
    }
    
    @Test
    public void test4Args() {
        String template = "<?xml version=\"1.0\"?> <entry xmlns=\"http://www.w3.org/2005/Atom\" xmlns:media=\"http://search.yahoo.com/mrss/\" xmlns:yt=\"http://gdata.youtube.com/schemas/2007\"> <media:group> <media:title type=\"plain\">%s</media:title> <media:description type=\"plain\">%s</media:description> <media:category scheme=\"http://gdata.youtube.com/schemas/2007/categories.cat\">%s</media:category> <media:keywords>%s</media:keywords> </media:group> </entry>";
        String expectedTemplate = "<?xml version=\"1.0\"?> <entry xmlns=\"http://www.w3.org/2005/Atom\" xmlns:media=\"http://search.yahoo.com/mrss/\" xmlns:yt=\"http://gdata.youtube.com/schemas/2007\"> <media:group> <media:title type=\"plain\">Feed 1</media:title> <media:description type=\"plain\">This is a Hello World</media:description> <media:category scheme=\"http://gdata.youtube.com/schemas/2007/categories.cat\">fun</media:category> <media:keywords>java; coding</media:keywords> </media:group> </entry>";
        String title = "Feed 1";
        String description = "This is a Hello World";
        String category = "fun";
        String keywords = "java; coding";
        
        assertEquals(expectedTemplate, AtomFormatter.getData(template, title, description, category, keywords));
    }
}
