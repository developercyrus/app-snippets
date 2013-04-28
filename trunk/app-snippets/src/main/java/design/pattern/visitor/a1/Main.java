package design.pattern.visitor.a1;

import java.util.ArrayList;
import java.util.List;

public class Main { 
    public static void main(String[] args) { 
        List<ICarElement> elements = new ArrayList<ICarElement>();
        elements.add(new Wheel());
        elements.add(new Body());
        elements.add(new Engine());
        
        Visitor visitorA = new VisitorA();

        for (ICarElement element : elements) {
            element.accept(visitorA);
        }
    } 
} 