package design.pattern.visitor.a3;

public class Postage implements Visitor {
    private double totalPostageForCart;     

    public double getTotalPostage() {
        return totalPostageForCart;    
    }

    @Override
    public void visit(Book book) {
        if(book.getPrice() < 10.0) {
            totalPostageForCart += book.getWeight() * 2;  
        }
    }

    @Override
    public void visit(CD cd) {
        if(cd.getPrice() < 10.0) {
            totalPostageForCart += cd.getWeight() * 3;  
        }
    }

    @Override
    public void visit(DVD dvd) {
        if(dvd.getPrice() < 10.0) {
            totalPostageForCart += dvd.getWeight() * 4;  
        }
    }

} 
