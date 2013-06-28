package snippets.rss.vtdxml.a1;

import java.io.File;
import java.io.FileInputStream;

import com.ximpleware.AutoPilot;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

public class RSSReaderWithoutXPath {
    public static void parse(String path) throws Throwable {
        File f = new File(path);
        FileInputStream fis =  new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        fis.read(b);
        VTDGen vg = new VTDGen();
        vg.setDoc(b);
        vg.parse(true);  // set namespace awareness to true
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        // select name space here; * matches any local name
        //ap.selectElementNS("http://purl.org/dc/elements/1.1/","*"); 
        ap.selectElementNS("*","*");
        int count = 0;
        while(ap.iterate()){
            System.out.print(""+vn.getCurrentIndex()+"  "+vn.getCurrentDepth()+"  ");     
            System.out.print("Element name ==> "+vn.toString(vn.getCurrentIndex()));
            int t = vn.getText(); // get the index of the text (char data or CDATA)
            if (t!=-1)
                System.out.println(" Text  ==> "+vn.toNormalizedString(t));
            System.out.println("\n ============================== ");
            count++;
        }
        System.out.println("Total # of element "+count);
    }
}