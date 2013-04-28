package design.pattern.visitor.a3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Visitable> items = new ArrayList<Visitable>();
        items.add(new Book(8, 10));
        items.add(new CD(5, 5));
        items.add(new DVD(6, 20));
        
        Postage postage = new Postage();         
        for(Visitable item: items) {
            item.accept(postage);
        }
        double total = postage.getTotalPostage();
        System.out.println(total);        
    }
}