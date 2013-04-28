package design.pattern.command.a1;

public class Multiple implements Command {
    private Integer[] params;
    
    public Multiple(Integer... params) {
        this.params = params;
    }
    
    @Override
    public Result execute() {
        Integer total = 1;
        for (Integer param : params) {
            total *= param;
        }
        return new Result(total);
    }
} 
