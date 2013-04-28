package design.pattern.object.adapter.a3;

public class Adapter implements Target{
    private Adaptee adaptee;
    
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void doSomething(){
        adaptee.doSomethingSpecial();
    }
}
