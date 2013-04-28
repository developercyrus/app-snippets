package design.pattern.visitor.a4;

public interface Visitor {
    //public void visit(Visitable visitable); 
    public void visit(Book book);
    public void visit(CD cd);
    public void visit(DVD dvd);  
}
