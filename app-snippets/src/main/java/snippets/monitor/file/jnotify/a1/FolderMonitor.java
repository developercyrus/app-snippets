package snippets.monitor.file.jnotify.a1;

import net.contentobjects.jnotify.JNotify;

public class FolderMonitor {
    private int duration = 0;
    private boolean isRenamed = false;
    private boolean isModified = false;
    private boolean isDeleted = false;
    private boolean isCreated = false;
    
    public boolean isRenamed() {
        return isRenamed;
    }
    public void setRenamed(boolean isRenamed) {
        this.isRenamed = isRenamed;
    }
    public boolean isModified() {
        return isModified;
    }
    public void setModified(boolean isModified) {
        this.isModified = isModified;
    }
    public boolean isDeleted() {
        return isDeleted;
    }
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    public boolean isCreated() {
        return isCreated;
    }
    public void setCreated(boolean isCreated) {
        this.isCreated = isCreated;
    }
    
    public FolderMonitor(int duration) {
        this.duration = duration;
    }
    
    
    public void listen(String path) throws Exception {        
        // watch mask, specify events you care about,
        // or JNotify.FILE_ANY for all events.
        int mask = JNotify.FILE_CREATED  
                    | JNotify.FILE_DELETED  
                    | JNotify.FILE_MODIFIED 
                    | JNotify.FILE_RENAMED;

        // watch subtree?
        boolean watchSubtree = true;

        // add actual watch
        Listener l = new Listener();
        int watchID = JNotify.addWatch(path, mask, watchSubtree, l);

        // sleep a little, the application will exit if you
        // don't (watching is asynchronous), depending on your
        // application, this may not be required
        Thread.sleep(duration);

        // to remove watch the watch
        boolean res = JNotify.removeWatch(watchID);
        if (!res) {
            // invalid watch ID specified.
        }
        
        this.setRenamed(l.isRenamed());
        this.setModified(l.isModified());
        this.setDeleted(l.isDeleted());
        this.setCreated(l.isCreated());
    }    
}
