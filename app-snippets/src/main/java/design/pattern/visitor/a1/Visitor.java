package design.pattern.visitor.a1;

public interface Visitor { 
    public void visit(Wheel element); 
    public void visit(Body element); 
    public void visit(Engine element); 
} 
