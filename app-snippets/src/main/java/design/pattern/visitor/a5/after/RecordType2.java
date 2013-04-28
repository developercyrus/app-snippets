package design.pattern.visitor.a5.after;

public class RecordType2 extends RecordType {
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}