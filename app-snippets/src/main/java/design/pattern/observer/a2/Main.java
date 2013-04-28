package design.pattern.observer.a2;

import java.util.Date;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {        
        NewsTopic topic = new NewsTopic();        
        Client client1 = new Client();
        Client client2 = new Client();        
        Client client3 = new Client();   
        topic.addObserver(client1);
        topic.addObserver(client2);
        topic.addObserver(client3);
             
        Random random = new Random();
        try {
            for (int i = 0; i < 3; i++) {
                // using push method, NewsTopic pro-actively notify message to client
                topic.push(new Message("News " + i, new Date()));
                Thread.sleep(random.nextInt(5000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
