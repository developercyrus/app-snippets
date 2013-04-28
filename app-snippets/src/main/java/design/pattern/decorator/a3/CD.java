package design.pattern.decorator.a3;

public class CD extends Computer {
    private Computer computer;
    
    public CD(Computer computer) {
        this.computer = computer;
    }
    
    @Override
    public String description() {        
        return computer.description() + " and a CD";
    }
    
}
