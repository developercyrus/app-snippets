package snippets.apache.commons.io.monitor.a1;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
 

public class FileAlterationListenerImpl implements FileAlterationListener {
    @Override
    public void onStart(final FileAlterationObserver observer) {
        
    }
 
    @Override
    public void onDirectoryCreate(final File directory) {
        System.out.println(directory.getAbsolutePath() + " was created.");
    }
 
    @Override
    public void onDirectoryChange(final File directory) {
        System.out.println(directory.getAbsolutePath() + " wa modified");
    }

    @Override
    public void onDirectoryDelete(final File directory) {
        System.out.println(directory.getAbsolutePath() + " was deleted.");
    }
 
    @Override
    public void onFileCreate(final File file) {
        System.out.println(file.getAbsoluteFile() + " was created.");
    }
 
    @Override
    public void onFileChange(final File file) {
        System.out.println(file.getAbsoluteFile() + " was modified.");
    }

    @Override
    public void onFileDelete(final File file) {
        System.out.println(file.getAbsoluteFile() + " was deleted.");
    }
 
    @Override
    public void onStop(final FileAlterationObserver observer) {
        
    }
}