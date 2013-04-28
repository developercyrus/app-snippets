package design.pattern.observer.a1.after;

public interface Observable {
    public void registerObserver(Observer observer);
    public void unregisterObserver(Observer observer);
    public void notifyObservers();
}
