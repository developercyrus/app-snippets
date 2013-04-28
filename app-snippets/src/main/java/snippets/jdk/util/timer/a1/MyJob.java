package snippets.jdk.util.timer.a1;

import java.util.TimerTask;

public class MyJob extends TimerTask {
    private boolean isRun = false;
    
    public void run() {
        if (isRun) {
            isRun = false;
        }
        else {
            isRun = true;
        }
    }
    
    public boolean isRun() {
        return isRun;
    }
}
