package snippets.jdk.lang.exception.custom.a1;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws BadDataSetException, CleanUpException {
        String file = "abc";
        FileInputStream in = null;
        
        try {
            in = new FileInputStream(file);
        }
        catch (IOException e) {
            throw new BadDataSetException();
        }
        finally {
            try {
                in.close();
            }
            catch (Exception e) {
                throw new CleanUpException();
            }
        }
    }   
}
