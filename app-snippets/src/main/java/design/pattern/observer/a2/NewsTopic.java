package design.pattern.observer.a2;

import java.util.Observable;

public class NewsTopic extends Observable {
    public void push(Message message) {
        setChanged();
        notifyObservers(message);
    }
}
