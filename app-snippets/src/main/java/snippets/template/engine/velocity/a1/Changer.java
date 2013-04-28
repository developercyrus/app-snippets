package snippets.template.engine.velocity.a1;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class Changer {
    private String result;
    
    public Changer(Map root, String filePath, String templateName) throws IOException {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("file.resource.loader.path", filePath);
        ve.init();

        System.out.println(filePath);
        
        VelocityContext context = new VelocityContext(root);  
        Template template = ve.getTemplate(templateName);
          
        StringWriter sw = new StringWriter();  
        template.merge(context, sw);  
        result = sw.toString(); 
    }
    
    public String getResult() {
        return result;
    }
}
