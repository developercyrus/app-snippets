package snippets.jdk.jaxb.nested.a1;

import javax.xml.bind.annotation.XmlAttribute;

public class Locale {
    @XmlAttribute()
    private int id;
    
    private String name;
    private String description;
    private String header;

    public Locale() {
    }
    public Locale(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
}
