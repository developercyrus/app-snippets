package snippets.jdk.util.concurrent.blockingqueue.a1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {    
    private final BlockingQueue<String> queue;
    
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
 
    @Override
    public void run() {
        System.out.println("consumer started");
        Random r = new Random();
        boolean isRunning = true;
        try {
            while (isRunning) {
                String data = queue.poll(1, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println(data + " take out from the queue...");
                    Thread.sleep(r.nextInt(2000));
                } else {
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("consumer ended");
        }
    }

}