package snippets.apache.poi.word.a1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor; 

public class MicrosoftWordReader {
    private String text;
    
    public MicrosoftWordReader() throws FileNotFoundException, IOException {
        String path = this.getClass().getResource("Word2003Sample.doc").getFile();
        InputStream is = new FileInputStream(new File(path));  
        WordExtractor doc = new WordExtractor(is); 
        text = doc.getText();  
    }
    
    public String getText() {
        return text;
    }
}
