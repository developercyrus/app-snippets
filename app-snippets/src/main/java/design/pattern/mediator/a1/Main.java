package design.pattern.mediator.a1;

public class Main {
    public static void main(String[] args) {
        /*
         * The mediator is a good choice of pattern when the communication 
         * between objects is complicated, but well defined. When there are 
         * too many relationships between the objects in your code, it's time 
         * to think of having such a central point of control.
         */
        
        ApplicationMediator mediator = new ApplicationMediator(); 

        Colleague desktopColleague = new DesktopColleague(mediator);
        Colleague mobileColleague = new MobileColleague(mediator);
        Colleague notebookColleague = new NotebookColleague(mediator);

        mediator.addColleague(desktopColleague);
        mediator.addColleague(mobileColleague);
        mediator.addColleague(notebookColleague);

        desktopColleague.send("Hello World");
        mobileColleague.send("Hello World"); 
        notebookColleague.send("Hello World"); 
    }
}
