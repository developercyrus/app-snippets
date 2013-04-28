package design.pattern.decorator.a3;

public class Disk extends Computer {
    private Computer computer;
    
    public Disk(Computer computer) {
        this.computer = computer;
    }
    
    @Override
    public String description() {        
        return computer.description() + " and a disk";
    }
}
