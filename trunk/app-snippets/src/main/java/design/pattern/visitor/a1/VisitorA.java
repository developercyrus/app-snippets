package design.pattern.visitor.a1;

public class VisitorA implements Visitor { 
    public void visit(Wheel element) { 
        element.operationA(); 
    }

    public void visit(Body element) { 
        element.operationB(); 
    }

    public void visit(Engine element) { 
        element.operationC(); 
    } 
}  