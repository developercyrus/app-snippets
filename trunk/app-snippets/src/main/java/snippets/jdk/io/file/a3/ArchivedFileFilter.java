package snippets.jdk.io.file.a3;

import java.io.File;
import java.io.FileFilter;

import javax.swing.filechooser.FileNameExtensionFilter;

public class ArchivedFileFilter implements FileFilter {
    private final FileNameExtensionFilter filter = new FileNameExtensionFilter("Compressed files", "zip", "jar", "z", "gz", "tar", "bz2", "bz");

    @Override
    public boolean accept(File file) {
        return filter.accept(file);
    }
}
