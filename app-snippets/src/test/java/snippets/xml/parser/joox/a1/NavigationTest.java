package snippets.xml.parser.joox.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class NavigationTest {

    @Test
    public void test1() throws IOException, SAXException {
        String path = this.getClass().getResource("file.xml").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        String expected = "1984";
        String actual = Navigation.extract(xmlStr);
        
        System.out.println(actual);
        assertEquals(expected, actual);
    }
  
}
