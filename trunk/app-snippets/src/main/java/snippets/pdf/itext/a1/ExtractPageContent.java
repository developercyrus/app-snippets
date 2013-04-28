package snippets.pdf.itext.a1;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
 
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
 
public class ExtractPageContent {
    public String parsePdf(String pdf) throws IOException {
        /*
        PdfReader reader = new PdfReader(pdf);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            pw.println(strategy.getResultantText());
        }
        pw.flush();
        pw.close();
        
        return sw.toString();
        */
        
        PdfReader reader = new PdfReader(pdf);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        StringBuffer sb = new StringBuffer();
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            sb.append(strategy.getResultantText());
        }

        return sb.toString();
    }
}