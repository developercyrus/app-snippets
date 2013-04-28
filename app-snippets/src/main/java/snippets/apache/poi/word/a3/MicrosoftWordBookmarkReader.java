package snippets.apache.poi.word.a3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Bookmarks;

public class MicrosoftWordBookmarkReader {
    private int bkmkCount;
    private List<String> l = new ArrayList<String>();
    
    public MicrosoftWordBookmarkReader() throws FileNotFoundException, IOException {
        String path = this.getClass().getResource("Policy_5YLP2011.dot").getFile();
        InputStream is = new FileInputStream(new File(path));  
        HWPFDocument wdDoc = new HWPFDocument(is);
        Bookmarks bkmkList = wdDoc.getBookmarks();
        bkmkCount = bkmkList.getBookmarksCount(); 

        for (int i = 0; i < bkmkCount; i++) {
            Bookmark bkmk = bkmkList.getBookmark(i);
            l.add(bkmk.getName());
        }
    }

    public int getBkmkCount() {
        return bkmkCount;
    }
    
    public List<String> getBkmkList() {
        return l;
    }
}
