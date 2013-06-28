package snippets.rss.vtdxml.a2;

import java.io.File;
import java.io.FileInputStream;

import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.ParseException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;

public class RSSReaderUsingXPath {

    public static void parse(String path) {
        try {
            // open a file and read the content into a byte array
            File f = new File(path);
            FileInputStream fis =  new FileInputStream(f);
            byte[] b = new byte[(int) f.length()];
            fis.read(b);
            //instantiate VTDGen
            //and call parse 
            VTDGen vg = new VTDGen();
            vg.setDoc(b);
            vg.parse(true);  // set namespace awareness to true
            VTDNav vn = vg.getNav();
            AutoPilot ap = new AutoPilot(vn);
            ap.declareXPathNameSpace("dc","http://purl.org/dc/elements/1.1/");
            ap.declareXPathNameSpace("rdf","http://www.w3.org/1999/02/22-rdf-syntax-ns#");
            ap.declareXPathNameSpace("sy","http://purl.org/rss/1.0/modules/syndication/");
            ap.declareXPathNameSpace("rss","http://purl.org/rss/1.0/");
            ap.declareXPathNameSpace("","http://purl.org/rss/1.0/");
            //ap.selectXPath("//ns1:*");           
            ap.selectXPath("/rdf:RDF/channel/dc:rights"); //expected=Copyright(C) 1994 - 2003 Network World, Inc.
            int result = -1;
            int count = 0;
            while((result = ap.evalXPath())!=-1){
                System.out.print(""+result+"  ");                  
                System.out.print("Element name ==> "+vn.toString(result));
                int t = vn.getText(); // get the index of the text (char data or CDATA)
                if (t!=-1)
                    
                    
                    System.out.println(" Text  ==> "+vn.toNormalizedString(t));
                System.out.println("\n ============================== ");
                count++;
            }
            System.out.println("Total # of element "+count);

        }
        catch (ParseException e){
            System.out.println(" XML file parsing error \n"+e);
        }
        catch (NavException e){
            System.out.println(" Exception during navigation "+e);
        }
        catch (XPathParseException e){

        }
        catch (XPathEvalException e){

        }
        catch (java.io.IOException e)
        {
            System.out.println(" IO exception condition"+e);
        }
    }
}