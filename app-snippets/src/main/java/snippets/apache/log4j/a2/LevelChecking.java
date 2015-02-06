package snippets.apache.log4j.a2;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LevelChecking {
    static Logger logger = Logger.getLogger(LevelChecking.class);

    public static void main(String[] args) throws IOException {
        URL propURL = LevelChecking.class.getResource("log4j.properties");
        String path = new File(propURL.getFile()).getParent();
        System.out.println(path);
        System.setProperty("log4jpath", path);
        
        PropertyConfigurator.configure(propURL);

        logger.setLevel(Level.ERROR); 
        if(logger.getLevel().equals(Level.ERROR)) {
            logger.error("should be logged");
        }
        
        logger.setLevel(Level.INFO); 
        if(logger.getLevel().equals(Level.ERROR)) {
            logger.error("should not be logged");
        }
    }
}
