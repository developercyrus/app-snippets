package snippets.apache.commons.io.fileutils.a1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class Copyer {
    public boolean copy(String orig, String dest) throws IOException {
        File fOrig = new File(orig);
        File fDest = new File(dest);
        FileUtils.copyFile(fOrig, fDest);
        
        return true;        
    }
    
    public static void main(String[] args) {
        System.out.println();
    }
}
