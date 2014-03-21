package snippets.jdk.awt.toolkit.clipboard.a1;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class Demo {
    public static void main(String[] args) {
        String str = "Hello World!";
        StringSelection s = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);  
        System.out.println(str + " is set to clipboard");
    }
}
