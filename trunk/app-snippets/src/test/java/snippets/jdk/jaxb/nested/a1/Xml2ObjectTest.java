package snippets.jdk.jaxb.nested.a1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Test;

public class Xml2ObjectTest {
    @Test
    public void test() throws JAXBException, IOException {
        String xmlPath = this.getClass().getResource("field.xml").getFile();        
        String line, xmlStr = "";
        BufferedReader br = new BufferedReader(new FileReader(xmlPath));       
        while ((line = br.readLine()) != null) {
            xmlStr = xmlStr + line;
        }
            
        Reader r = new StringReader(xmlStr);
        
        JAXBContext c = JAXBContext.newInstance(Field.class);
        Field field = (Field) c.createUnmarshaller().unmarshal(r);
        
        
        
        Integer[] expectedIds = {3, 4};
        String[] expectedNames = {"RB", "TB"};
        String[] expectedDescriptions = {"My Custom Radio Button", "My Custom TextBox"};
        String[] expectedHeaders = {"header3", "header4"};
        
        List<Integer> actualListIds = new ArrayList<Integer>();
        List<String> actualListNames = new ArrayList<String>();
        List<String> actualListDescriptions = new ArrayList<String>();
        List<String> actualListHeaders = new ArrayList<String>();
        
        List<Locale> locales = field.getLocale();
        for (Locale locale : locales) {
            actualListIds.add(locale.getId());
            actualListNames.add(locale.getName());
            actualListDescriptions.add(locale.getDescription());
            actualListHeaders.add(locale.getHeader());
        }
        
        Integer[] actualIds = new Integer[actualListIds.size()];
        String[] actualNames = new String[actualListNames.size()];
        String[] actualDescriptions = new String[actualListDescriptions.size()];
        String[] actualHeaders = new String[actualListHeaders.size()];
        
        actualIds = actualListIds.toArray(actualIds);
        actualNames = actualListNames.toArray(actualNames);
        actualDescriptions = actualListDescriptions.toArray(actualDescriptions);
        actualHeaders = actualListHeaders.toArray(actualHeaders);
                
        assertArrayEquals(expectedIds, actualIds);
        assertArrayEquals(expectedNames, actualNames);
        assertArrayEquals(expectedDescriptions, actualDescriptions);
        assertArrayEquals(expectedHeaders, actualHeaders);
        
        assertEquals(1, field.getFolderFieldID());
        assertEquals("ExternalUse", field.getScope());
    }
}
