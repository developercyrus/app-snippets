package snippets.xml.xpath.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;

public class ClientTest {
    @Test
    public void test() throws IOException, XPathExpressionException {
        String path = this.getClass().getResource("iciba.success.xml").getFile();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line, xmlStr = new String();
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
        
        String expected = "http://res.iciba.com/resource/amp3/0/0/e7/fe/e7fed1944be880f14a7335eac65e2cc2.mp3";
        String actual = Client.extract(xmlStr, "/dict/pron").trim();
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
