package snippets.jdk.jmx.a2;

import java.util.concurrent.atomic.AtomicLong;

public class Hello implements HelloMBean {
    private final AtomicLong counter = new AtomicLong(0L);
    private final long startTimeMillis = System.currentTimeMillis();

    public void run() throws InterruptedException {
        while (true) {
            counter.incrementAndGet();
            Thread.sleep(5000);
        }
    }

    public long getCount() {
        return counter.get();
    }

    public void setCount(long val) {
        counter.set(val);
    }

    public long getUptimeMillis() {
        return System.currentTimeMillis() - startTimeMillis;
    }

    public void printStuff(String stuff) {
        System.out.println(stuff);
    }

    public void printCount() {
        System.out.println(counter.get());
    }
   
}