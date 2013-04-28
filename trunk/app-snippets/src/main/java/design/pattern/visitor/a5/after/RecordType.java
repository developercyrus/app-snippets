package design.pattern.visitor.a5.after;

public abstract class RecordType {
    public abstract <T> T accept(Visitor<T> visitor);
}