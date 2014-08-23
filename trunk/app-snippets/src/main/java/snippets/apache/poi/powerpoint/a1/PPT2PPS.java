package snippets.apache.poi.powerpoint.a1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.SlideShow;

public class PPT2PPS {

    public static void main(String[] args) throws IOException {        
        String src = PPT2PPS.class.getResource("slideshow1.ppt").getFile();
        String dest = (new File(PPT2PPS.class.getResource("PPT2PPS.class").getFile())).getParentFile().getCanonicalPath() + "/slideshow1.pps";
        
        FileInputStream is = new FileInputStream(src);
        SlideShow ppt = new SlideShow(is);
       
        FileOutputStream out = new FileOutputStream(new File(dest));
        ppt.write(out);
        out.close();
    }
}
