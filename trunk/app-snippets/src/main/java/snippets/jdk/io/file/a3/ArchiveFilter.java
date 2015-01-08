package snippets.jdk.io.file.a3;

import java.io.File;
import java.io.FileFilter;

public class ArchiveFilter {
    public static void main(String[] args) {
        String path = ArchiveFilter.class.getResource(".").getPath();
        File rootDir = new File(path);
        FileFilter filter = new ArchivedFileFilter();
      
        File[] files = rootDir.listFiles(filter);
        for (File f : files) {
            System.out.println(f.getName());
        }
    }  
}
