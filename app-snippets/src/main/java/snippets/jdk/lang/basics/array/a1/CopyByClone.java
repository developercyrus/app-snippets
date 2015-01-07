package snippets.jdk.lang.basics.array.a1;

import java.util.Arrays;

public class CopyByClone {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        System.out.println(Arrays.toString(a1));

        int[] a2 = a1.clone();
        System.out.println(Arrays.toString(a1));

        int[] a3 = Arrays.copyOf(a1, a1.length);
        System.out.println(Arrays.toString(a1));
    }
}
