package snippets.template.engine.freemarker.a1;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Changer {
 private String result;
    
    public Changer(Map root, String filePath, String templateName) throws TemplateException, IOException {
        Configuration cfg = new Configuration();  
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
        //cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));          
        cfg.setDirectoryForTemplateLoading(new File(filePath));  
        Template template = cfg.getTemplate(templateName);
        
        Writer out = new StringWriter();
        template.process(root, out);  
        out.flush();  
        result = out.toString();
    }
    
    public String getResult() {
        return result;
    }
}
