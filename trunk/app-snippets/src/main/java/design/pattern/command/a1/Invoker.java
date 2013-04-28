package design.pattern.command.a1;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private Map<String, Command> commands;
    
    public Invoker() {
        commands = new HashMap<String, Command>();
    }
    
    public void addCommand(String commName, Command command) {
        commands.put(commName, command);
    }
    
    public Result request(String commName) {
        Command command = (Command) commands.get(commName);
        return command.execute();
    }
}