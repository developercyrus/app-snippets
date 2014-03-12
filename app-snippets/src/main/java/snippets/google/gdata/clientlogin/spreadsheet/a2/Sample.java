package snippets.google.gdata.clientlogin.spreadsheet.a2;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class Sample {
    public static void main(String[] args) throws IOException, ServiceException {
        Sample s = new Sample();
        s.upload("", "");
    }
    
    public void upload(String username, String password) throws IOException, ServiceException {
        SpreadsheetService service = new SpreadsheetService("POLYU-LIBRRAY"); 
        service.setUserCredentials(username, password);
        
        FeedURLFactory factory = FeedURLFactory.getDefault();
        SpreadsheetFeed spreadSheetFeed = service.getFeed(factory.getSpreadsheetsFeedUrl(), SpreadsheetFeed.class);
        List<SpreadsheetEntry> spreadsheets = spreadSheetFeed.getEntries();
        
        Iterator<SpreadsheetEntry> iterator = spreadsheets.iterator();
        
        while (iterator.hasNext()) {
            SpreadsheetEntry spreadSheetEntry = iterator.next();
            System.out.println("spreadsheet name:" + spreadSheetEntry.getTitle().getPlainText());            
            
            if (spreadSheetEntry.getTitle().getPlainText().equals("POLYU_LIBRARY_RECORD")) {                       
                List<WorksheetEntry> worksheets = spreadSheetEntry.getWorksheets();
                WorksheetEntry worksheet = worksheets.get(0);
                
                String title = worksheet.getTitle().getPlainText();
                URL listFeedUrl = worksheet.getListFeedUrl();
                System.out.println(listFeedUrl.toString());
                ListFeed feed = service.getFeed(listFeedUrl, ListFeed.class);
                for (ListEntry entry : feed.getEntries()) {
                System.out.println(entry.getTitle().getPlainText());
                    for (String tag : entry.getCustomElements().getTags()) {
                        System.out.println("<gsx:" + tag + ">" + entry.getCustomElements().getValue(tag) + "</gsx:" + tag + ">");
                    }
                }
            }
        }
    }
}
