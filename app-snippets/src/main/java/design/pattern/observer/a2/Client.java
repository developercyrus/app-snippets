package design.pattern.observer.a2;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Client implements Observer {
    public void update(Observable observable, Object obj) {
        Random random = new Random();
        
        if(observable instanceof NewsTopic) {
            if (obj instanceof Message) {                
                try {
                    Thread.sleep(random.nextInt(2000));
                    System.out.println(
                        String.format(
                            "Client %s receive message, %s, at %s",
                            Integer.toHexString(this.hashCode()), 
                            obj, 
                            new Date()                
                        )
                    );                      
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}