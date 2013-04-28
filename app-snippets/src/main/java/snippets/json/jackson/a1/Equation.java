package snippets.json.jackson.a1;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.functors.InstantiateFactory;
import org.apache.commons.collections.list.LazyList;

public class Equation {
    private List<Element> elements;

    public Equation() {
        elements = LazyList.decorate(new ArrayList<Element>(), new InstantiateFactory(Element.class));
    }
    
    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}

