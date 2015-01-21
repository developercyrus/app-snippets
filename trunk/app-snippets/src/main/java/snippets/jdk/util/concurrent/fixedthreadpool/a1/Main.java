package snippets.jdk.util.concurrent.fixedthreadpool.a1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class Main {
    public static void main(String[] args) {
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
 
        Callable<String> aCallable = new Callable<String>() {
            String result = "Callable done!";
            @Override
            public String call() throws Exception {
                System.out.println("Callable at work!");
                Thread.sleep(5 * 1000);
                System.out.println(result);
                return result;
            }
        };
 

        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable at work!");
                    Thread.sleep(5 * 1000);
                    System.out.println("Runnable done!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
 
        // Submit two tasks for running
        Future<String> callableFuture = fixedPool.submit(aCallable);
        Future<?> runnableFuture = fixedPool.submit(aRunnable);
 
        fixedPool.shutdown(); // shut down
    }
}
