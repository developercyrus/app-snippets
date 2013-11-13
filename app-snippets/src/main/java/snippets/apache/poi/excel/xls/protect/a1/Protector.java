package snippets.apache.poi.excel.xls.protect.a1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Protector {
    public void setPassword(String path, String password) throws IOException {

        FileInputStream fileInput = new FileInputStream(path);           
        BufferedInputStream bufferInput = new BufferedInputStream(fileInput);      
        POIFSFileSystem poiFileSystem = new POIFSFileSystem(bufferInput);  
      
        Biff8EncryptionKey.setCurrentUserPassword(password);            
        HSSFWorkbook workbook = new HSSFWorkbook(poiFileSystem, true);            
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.writeProtectWorkbook(Biff8EncryptionKey.getCurrentUserPassword(), "");
        workbook.write(fileOut);              
    }
}
