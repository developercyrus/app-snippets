package snippets.jdk.jaxb.annotation.a1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


