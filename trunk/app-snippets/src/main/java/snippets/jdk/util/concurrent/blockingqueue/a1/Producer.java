package snippets.jdk.util.concurrent.blockingqueue.a1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private final BlockingQueue queue;
    private static AtomicInteger count = new AtomicInteger();
    
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
 
    @Override
    public void run() {
        String data = null;
        Random r = new Random();
 
        System.out.println("producer started");
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(2000));
 
                data = "data:" + count.incrementAndGet();
                System.out.println(data + " put into the queue...");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("failed put data：" + data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("producer ended");
        }
    }
 
    public void stop() {
        isRunning = false;
    }
 

 
}