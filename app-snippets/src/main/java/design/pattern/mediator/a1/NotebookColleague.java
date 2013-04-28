package design.pattern.mediator.a1;

public class NotebookColleague extends Colleague {
    public NotebookColleague(Mediator m) {
        super(m);
    }

    public void receive(String message) {
        System.out.println("Notebook Received: " + message);
    }    
}