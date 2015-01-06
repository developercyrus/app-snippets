package snippets.jdk.lang.basics.bitwise.a1;

public class CheckIsOdd {

    public static void main(String[] args) {
        System.out.println(isOdd(43));
    }

    public static boolean isOdd(int x) {
        /*
             AND operation
             
                00101011
            &   00000001   
                --------
                00000001
             
         */

        if ((x & 1) == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
