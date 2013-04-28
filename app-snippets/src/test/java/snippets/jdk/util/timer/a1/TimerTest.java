package snippets.jdk.util.timer.a1;

import static org.junit.Assert.assertEquals;

import java.util.Timer;

import org.junit.Test;

public class TimerTest {
    @Test
    public void test1() throws InterruptedException {
        Timer t = new Timer();
        MyJob job = new MyJob();
        
        // execute once only, changing false to true
        t.scheduleAtFixedRate(job, 1000, 1000);
        Thread.sleep(1500);
        
        boolean actual = job.isRun();
        assertEquals(true, actual);
    }
    
    @Test
    public void test2() throws InterruptedException {
        Timer t = new Timer();
        MyJob job = new MyJob();
        
        // execute twice only, changing false to true, and to false
        t.scheduleAtFixedRate(job, 1000, 1000);
        Thread.sleep(2500);
        
        boolean actual = job.isRun();
        assertEquals(false, actual);
    }
}
