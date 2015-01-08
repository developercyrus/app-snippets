package snippets.algorithm.sort.externalsort.a1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NumberListGenerator {
    public static void main(String[] args) throws IOException {
        String path = NumberListGenerator.class.getResource(".").getFile();
        System.out.println(path);

        BufferedWriter out = new BufferedWriter(new FileWriter(path + "/1000000.int"));        
        Random r = new Random();
        for (int i=0; i<1000000; i++) {
            out.write(String.valueOf(r.nextInt(1000000)));
            out.newLine();
        }
        out.flush();
        out.close();
    }
}

