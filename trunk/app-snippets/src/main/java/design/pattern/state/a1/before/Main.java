package design.pattern.state.a1.before;

public class Main {
    private int STATE = 1;
    private final int OFF = 1;
    private final int SMALL = 2;
    private final int MEDIUM = 3;
    private final int LARGE = 4;

    public static void main(String[] args) {
        Main main = new Main();
        main.next();
        main.next();
        main.next();
        main.next();
    }

    public void next() {
        switch (STATE) {
            case OFF:  System.out.println( "small fire" ); 
            break;
            case SMALL:  System.out.println( "medium fire" );
            break;
            case MEDIUM:  System.out.println( "large fire" );
            break;
            case LARGE:  System.out.println( "off fire" );
            break;
            
            default: System.out.println( "invalid" );
            break;
        }
        STATE = STATE % 4;
        STATE++;
       
    }
}
