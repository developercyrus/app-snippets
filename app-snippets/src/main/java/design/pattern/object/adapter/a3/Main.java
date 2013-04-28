package design.pattern.object.adapter.a3;

public class Main {
    public static void main(String[] args) {
        Adaptee adaptee = new AdapteeImpl();
        Target target = new Adapter(adaptee);
        target.doSomething();
    }
}
