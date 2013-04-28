package design.pattern.visitor.a4;

public class CD implements Visitable {
    private double price;
    private double weight;
    
    public CD(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public <T> T accept(ReturningVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double getPrice() {      
        return price;        
    }

    public double getWeight() {
        return weight;
    }
}
