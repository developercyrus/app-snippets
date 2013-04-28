package design.pattern.visitor.a3;

public interface Visitor {
    // second dispatch
    public void visit(Book book);
    public void visit(CD cd);
    public void visit(DVD dvd);
}
