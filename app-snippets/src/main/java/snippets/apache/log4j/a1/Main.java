package snippets.apache.log4j.a1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        URL propURL = Main.class.getResource("log4j.properties");
        String path = new File(propURL.getFile()).getParent();
        System.out.println(path);
        System.setProperty("log4jpath", path);
        
        Properties properties = new Properties();        
        PropertyConfigurator.configure(propURL);

        logger.setLevel(Level.INFO); 
        logger.info("Entering application.");
        logger.info("Exiting application.");                
    }
}
