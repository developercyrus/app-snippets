package snippets.apache.poi.excel.xlsx.unprotect.a1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Unprotector {
    
    public String unlock(String path, String password) throws IOException, GeneralSecurityException {
        FileInputStream fileInput = new FileInputStream(path); 
        POIFSFileSystem poiFileSystem = new POIFSFileSystem(fileInput); 
        
        EncryptionInfo info = new EncryptionInfo(poiFileSystem);
        Decryptor d = Decryptor.getInstance(info);
        d.verifyPassword(password);         
        InputStream dataStream = d.getDataStream(poiFileSystem);
        
        XSSFWorkbook wb = new XSSFWorkbook(dataStream);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        return cell.getStringCellValue();
    }

}
