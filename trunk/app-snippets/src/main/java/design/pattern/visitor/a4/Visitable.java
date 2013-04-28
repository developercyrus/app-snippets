package design.pattern.visitor.a4;

public interface Visitable {
    public <T> T accept(ReturningVisitor<T> visitor);
    public void accept(Visitor visitor);
} 