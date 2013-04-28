package design.pattern.command.a1;

public class Minus implements Command {
    private Integer[] params;
    
    public Minus(Integer... params) {
        this.params = params;
    }
    
    @Override
    public Result execute() {
        Integer total = 0;
        for (Integer param : params) {
            total -= param;
        }
        return new Result(total);
    }
} 