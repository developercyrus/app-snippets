package snippets.pdf.itext.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

public class TestExtractPageContent {
    @Ignore
    @Test
    public void test() throws IOException {
        String space = System.getProperty("line.separator");
        
        String pathActual = this.getClass().getResource("preface.pdf").getFile();        
        ExtractPageContent egc = new ExtractPageContent();
        String actual = egc.parsePdf(pathActual).trim();
        
        String pathExpected = this.getClass().getResource("preface.txt").getFile();
        BufferedReader br = new BufferedReader(new FileReader(pathExpected));
        String line, expected = new String("");
        while ((line = br.readLine()) != null) {
            if (expected.equals("")) { 
                expected = line;
            }
            else {
                expected = expected + space + line;
            }
        }
        expected = expected.trim();
                
        //System.out.println(actual);
        //System.out.println(expected);
        
        //System.out.println( DigestUtils.md5Hex(actual) );
        //System.out.println( DigestUtils.md5Hex(expected) );
        
        assertEquals(expected.trim(), actual.trim());
    }

    @Test
    public void test2() throws IOException {
        String pathActual = this.getClass().getResource("comm3000.pdf").getFile();        
        ExtractPageContent egc = new ExtractPageContent();
        String actual = egc.parsePdf(pathActual).trim();
        
        System.out.println(actual); 
    }
}
