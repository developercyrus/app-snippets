package snippets.jdk.util.zip.a1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ReadingJarFile {
    List<String> fileList = new ArrayList<String>();
    
    public ReadingJarFile() throws IOException {
        String jarFilename = this.getClass().getResource("SIA.Util.jar").getFile();
        JarFile jarFile = new JarFile(jarFilename);
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String entryName = entry.getName();
            fileList.add(entryName);
            System.out.println(entryName);
        }
    }
    
    public static void main(String[] args) throws IOException {
        new ReadingJarFile();
    }
    
    public String[] getList() {
        String[] files = new String[fileList.size()];
        files = fileList.toArray(files);
        return files;
    }
}
