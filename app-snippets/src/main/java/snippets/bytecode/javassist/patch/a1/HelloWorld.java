package snippets.bytecode.javassist.patch.a1;

public class HelloWorld {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Serial Needed..");
            return;
        }

        if (checkSerial(args[0]) == false ) {
            System.exit(0);
        }
         
        System.out.println("Hello World!");        
    }
    
    public static boolean checkSerial(String serial){
        if (serial.equals("1234")) {
            return true;
        }
        else {
            return false;
        }
    }
}
