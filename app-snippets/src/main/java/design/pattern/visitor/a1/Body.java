package design.pattern.visitor.a1;

public class Body implements ICarElement { 
    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    }

    public void operationB() { 
        System.out.println("Moving body..."); 
    }
} 
