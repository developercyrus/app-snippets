package design.pattern.visitor.a1;

public class Engine implements ICarElement { 
    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    }

    public void operationC() { 
        System.out.println("Starting engine..."); 
    } 
} 

