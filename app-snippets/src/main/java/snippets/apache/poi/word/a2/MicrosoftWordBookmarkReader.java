package snippets.apache.poi.word.a2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmark;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.Range;

public class MicrosoftWordBookmarkReader {
    private int bkmkCount;
    private Map<String, String> m = new HashMap<String, String>();
    
    public MicrosoftWordBookmarkReader() throws FileNotFoundException, IOException {
        String path = this.getClass().getResource("Word2003BookmarkSample.doc").getFile();
        InputStream is = new FileInputStream(new File(path));  
        HWPFDocument wdDoc = new HWPFDocument(is);
        Bookmarks bkmkList = wdDoc.getBookmarks();
        bkmkCount = bkmkList.getBookmarksCount(); 

        for (int i = 0; i < bkmkCount; i++) {
            Bookmark bkmk = bkmkList.getBookmark(i);
            Range bkmkRange = new Range(bkmk.getStart(), bkmk.getEnd(), wdDoc);
            m.put(bkmk.getName(), bkmkRange.text().trim());
        }
    }

    public int getBkmkCount() {
        return bkmkCount;
    }
    
    public Map<String, String> getBkmkMap() {
        return m;
    }
}
