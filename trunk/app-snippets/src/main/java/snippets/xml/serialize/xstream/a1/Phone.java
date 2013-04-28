package snippets.xml.serialize.xstream.a1;

public class Phone {
    private String model;
    private int number;
    
    public Phone() {        
    }
    
    public Phone(String model, int number) {
        this.model = model;
        this.number = number;
    }
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
