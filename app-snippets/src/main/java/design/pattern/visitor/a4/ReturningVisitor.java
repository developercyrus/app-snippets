package design.pattern.visitor.a4;

public interface ReturningVisitor<T> {
    public T visit(Book book);
    public T visit(CD cd);
    public T visit(DVD dvd);  
}