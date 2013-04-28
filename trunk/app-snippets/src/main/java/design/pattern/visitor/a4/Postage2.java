package design.pattern.visitor.a4;

public class Postage2 implements ReturningVisitor<Object> {
    @Override
    public Object visit(Book book) {        
        if(book.getPrice() < 10.0) {
            return book.getWeight() * 2;  
        }
        return 0;
    }

    @Override
    public Object visit(CD cd) {
        if(cd.getPrice() < 10.0) {
            return cd.getWeight() * 3;  
        }
        return 0;
    }


    @Override
    public Object visit(DVD dvd) {
        if(dvd.getPrice() < 10.0) {
            return dvd.getWeight() * 4;  
        }
        return 0;
    }

} 
