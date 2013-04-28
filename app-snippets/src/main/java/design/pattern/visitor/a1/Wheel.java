package design.pattern.visitor.a1;

public class Wheel implements ICarElement { 
    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    }

    public void operationA() { 
        System.out.println("Kicking wheel..."); 
    } 
} 