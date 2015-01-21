package snippets.jdk.util.concurrent.blockingqueue.a1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
 
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);       
        Consumer consumer = new Consumer(queue);
 
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(consumer);
 
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
 
        Thread.sleep(2000);
        service.shutdown();
    }
}