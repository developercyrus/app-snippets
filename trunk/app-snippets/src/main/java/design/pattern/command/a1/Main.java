package design.pattern.command.a1;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.addCommand("add", new Add(3, 5, 6));
        invoker.addCommand("minus", new Minus(8, 6, 9));
        invoker.addCommand("multiple", new Multiple(2, 1, 4));

        // simulate random request
        // Invoker never knows what request will be received, but it always executes the request
        /*
         *  现在许多Web MVC Framework 也都采用Command模式来设计Controller，
         *  在这样的例子中，Container就好比Command模式中Client的角色，
         *  而前端 Controller（例如JSP技术中通常会采用的Dispatcher Servlet）就相当于Invoker，
         *  而Action则相当于ICommand的角色，
         *  至于Receiver角色就是您封装在Action中执行的物件了。
         */
        String[] request = {"add", "minus", "multiple"};
        while(true) {
            int i = (int) (Math.random() * 10) % 3;
            System.out.println(invoker.request(request[i]));
        }
    }
}
