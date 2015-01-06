package snippets.jdk.thread.shutdownhook.a1;

public class ShutdownThread extends Thread {
    private SampleThread sampleThread = null;

    public ShutdownThread(SampleThread shutdown) {
        super();
        this.sampleThread = shutdown;
    }

    @Override
    public void run() {
        System.out.println("[Shutdown thread] Shutting down");
        sampleThread.stop();
        System.out.println("[Shutdown thread] Shutdown complete");
    }
}