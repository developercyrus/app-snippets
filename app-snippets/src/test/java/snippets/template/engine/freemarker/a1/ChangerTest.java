package snippets.template.engine.freemarker.a1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.TemplateException;

public class ChangerTest {
    @Test
    public void test() throws IOException, TemplateException {
        Map latest = new HashMap();  
        latest.put("url", "products/redmouse.html");  
        latest.put("name", "red mouse");  
          
        Map root = new HashMap();  
        root.put("user", "Small John");  
        root.put("latestProduct", latest);  
        root.put("number", new Long(3333));  
          
        List listTest = new ArrayList();  
        listTest.add("5");  
        listTest.add("4");  
          
        root.put("list",listTest);
        
        
        String path = this.getClass().getResource("sample.ftl").getFile();
        String absolutePath = new File(path).getAbsolutePath();
        String filePath = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));        
        
        String actualPath = this.getClass().getResource("sample.result").getFile();
        BufferedReader br = new BufferedReader(new FileReader(actualPath));
        String line, actual = new String();
        while ((line = br.readLine()) != null) {
            actual = actual + line + System.getProperty("line.separator");
        }
        
        Changer changer = new Changer(root, filePath, "sample.ftl");
        String expected = changer.getResult();
        System.out.println(expected);
        
        //assertEquals(expected.trim(), actual.trim());        
    }
}
