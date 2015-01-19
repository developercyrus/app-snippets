package snippets.monitor.file.jnotify.a1;

import net.contentobjects.jnotify.JNotifyListener;

public class Listener implements JNotifyListener {
    private boolean isRenamed = false;
    private boolean isModified = false;
    private boolean isDeleted = false;
    private boolean isCreated = false;
    
    public boolean isRenamed() {
        return isRenamed;
    }
    public boolean isModified() {
        return isModified;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public boolean isCreated() {
        return isCreated;
    }
    
    
    @Override
    public void fileRenamed(int wd, String rootPath, String oldName, String newName) {  
        this.isRenamed = true;
        System.err.println("renamed " + rootPath + " : " + oldName + " -> " + newName);
    }
    @Override
    public void fileModified(int wd, String rootPath, String name) {
        this.isModified = true;
        System.err.println("modified " + rootPath + " : " + name);
    }
    @Override
    public void fileDeleted(int wd, String rootPath, String name) {
        this.isDeleted = true;
        System.err.println("deleted " + rootPath + " : " + name);
    }
    @Override
    public void fileCreated(int wd, String rootPath, String name) {
        this.isCreated = true;
        System.err.println("created " + rootPath + " : " + name);
    }
    
    
    
}
