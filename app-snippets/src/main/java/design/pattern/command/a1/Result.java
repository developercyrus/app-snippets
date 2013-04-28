package design.pattern.command.a1;

public class Result {
    private Integer total;
    
    public Result(Integer total) {
        this.total = total;
    }
    
    public String toString() {
        return String.valueOf(total);
    }
}
