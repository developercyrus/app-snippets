package snippets.jdk.jdbc.blob.sqlite.a1;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONObject;

public class SoundExtract {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {        
/*
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/cyrus/Downloads/SentSound.db3");
        PreparedStatement pstmt = conn.prepareStatement("select SoundData from SentSound where ID=?");
        pstmt.setString(1, "4c92d646062798481d9aa203");
        ResultSet rs = pstmt.executeQuery(); 
        rs.next(); 

        File file = new File("C:/Users/cyrus/Downloads/2.mp3"); 
        if(!file.exists()) { 
            file.createNewFile();
        } 
        FileOutputStream fos = new FileOutputStream(file); 
        byte[] soundBytes = rs.getBytes("SoundData");
        fos.write(soundBytes);
        fos.flush();
        
        fos.close(); 
        rs.close(); 
        pstmt.close(); 
        conn.close(); 
*/       
        
/*        
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/cyrus/Downloads/WordDict.db3");
        PreparedStatement pstmt = conn.prepareStatement("select BaseInfo, ExtraInfo from WordDict where ID=?");
        pstmt.setString(1, "0566d4a20f88a3da767eb620170af6e0");
        ResultSet rs = pstmt.executeQuery(); 
        rs.next(); 
        byte[] objBytes = rs.getBytes("BaseInfo");
        ByteArrayInputStream in = new ByteArrayInputStream(objBytes);
        ObjectInputStream is = new ObjectInputStream(in);
        JSONObject result = (JSONObject) is.readObject(); 
        System.out.println(result.getString("word"));
        
        rs.close(); 
        pstmt.close(); 
        conn.close(); 
*/     
        
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/cyrus/Downloads/WordDict.db3");
        PreparedStatement pstmt = conn.prepareStatement("select BaseInfo, ExtraInfo from WordDict where ID=?");
        pstmt.setString(1, "0566d4a20f88a3da767eb620170af6e0");
        ResultSet rs = pstmt.executeQuery(); 
        rs.next(); 
        byte[] objBytes = rs.getBytes("BaseInfo");        
        System.out.println(new String(objBytes));
        
        rs.close(); 
        pstmt.close(); 
        conn.close(); 
    }
}
