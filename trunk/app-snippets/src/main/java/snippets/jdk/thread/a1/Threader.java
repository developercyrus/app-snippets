package snippets.jdk.thread.a1;

public class Threader extends Thread {   
    public Threader(String name)    {
        super(name);
    }
    
    @Override
    public void run()   {
        try {
            System.out.println(Thread.currentThread().getName() + " is runnning.");
            Thread.sleep(1000);
        }
        catch(InterruptedException e)     {
            e.printStackTrace();
        }
    }
}