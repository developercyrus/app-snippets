package snippets.apache.commons.lang.time.stopwatch.a1;

import org.apache.commons.lang.time.StopWatch;

public class MyStopWatch {
    public static void main (String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        Thread.sleep(5000);
        watch.stop();
        System.out.println("Time taken is " + watch.getTime() + " ms");
    }
}
