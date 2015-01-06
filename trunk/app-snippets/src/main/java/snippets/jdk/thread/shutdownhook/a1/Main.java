package snippets.jdk.thread.shutdownhook.a1;

/* 
    reference: http://esus.com/trapping-ctrl-c-java-app/
  
    Main class which tests the two classes
    We let the sample thread run for 10 seconds 
    and then force a Shutdown with System.exit(0). 
    You may stop the program early by pressing CTRL-C.
    
 */
public class Main {
    public static void main(String [] args) {
        SampleThread shutdown = new SampleThread();
        try {
            Runtime.getRuntime().addShutdownHook(new ShutdownThread(shutdown));
            System.out.println("[Main thread] Shutdown hook added");
        } catch (Throwable t) {
            // we get here when the program is run with java version 1.2.2 or older
            System.out.println("[Main thread] Could not add Shutdown hook");
        }

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        
        //When jvm closes, it takes effect for addShutdownHook() by calling ShutdownThread.start()
        System.out.println("[Main thread] calling exit(0)");
        System.exit(0);
    }
}