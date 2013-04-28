package design.pattern.visitor.a5.after;

public interface Visitor<T> {
    public T visit(RecordType1 recordType);
    public T visit(RecordType2 recordType);
}