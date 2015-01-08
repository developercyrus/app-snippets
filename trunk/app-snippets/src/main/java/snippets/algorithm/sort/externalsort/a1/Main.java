package snippets.algorithm.sort.externalsort.a1;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import com.google.code.externalsorting.ExternalSort;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputfile = Main.class.getResource("1000000.int").getFile();
        String outputfile = Main.class.getResource(".").getFile() + "1000000.int.sorted";

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //natural order
                return Integer.parseInt(s1)-Integer.parseInt(s2);
            }
        };
            
        List<File> l = ExternalSort.sortInBatch(new File(inputfile), comparator) ;
        ExternalSort.mergeSortedFiles(l, new File(outputfile), comparator);
    }
}



