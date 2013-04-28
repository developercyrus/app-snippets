package snippets.google.gdata.clientlogin.spreadsheet.a1;

import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        System.out.println("URL: " + Thread.currentThread().getContextClassLoader().getResource("com/google/common/collect/ImmutableSet.class")); 
        
        Sample s = new Sample();
        s.upload("", "", "");
    }
    
    public void upload(String value, String username, String password) throws IOException, ServiceException {
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        
        String DATE = format.format(cal.getTime());
        String JOBS = value;
        
        System.out.println(DATE);
        System.out.println(JOBS);
        
        
        final String appName = "sampleCo-WorksheetDemo-0.9";
        SpreadsheetService service = new SpreadsheetService(appName); 
        service.setUserCredentials(username, password);
        
        FeedURLFactory factory = FeedURLFactory.getDefault();
        SpreadsheetFeed spreadSheetFeed = service.getFeed(factory.getSpreadsheetsFeedUrl(), SpreadsheetFeed.class);
        List<SpreadsheetEntry> spreadsheets = spreadSheetFeed.getEntries();
        SpreadsheetEntry spreadSheetEntry = spreadsheets.get(0);
        
        System.out.println(spreadSheetEntry.getTitle().getPlainText());
        
        List<WorksheetEntry> worksheets = spreadSheetEntry.getWorksheets();
        WorksheetEntry worksheet = worksheets.get(0);
        
        String title = worksheet.getTitle().getPlainText();
        int rowCount = worksheet.getRowCount();
        int colCount = worksheet.getColCount();
        System.out.println(title + "\trows:" + rowCount + "\tcols: " + colCount);
            
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
