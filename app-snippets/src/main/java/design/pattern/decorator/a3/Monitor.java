package design.pattern.decorator.a3;

public class Monitor extends Computer {
    private Computer computer;
    
    public Monitor(Computer computer) {
        this.computer = computer;
    }
    
    @Override
    public String description() {        
        return computer.description() + " and a monitor";
    }
    
}
