package snippets.jdk.net.referrer.a1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HKProperties {
public static void main(String[] args) throws Exception {
        
        //http://proptx.midland.com.hk/unit/index.jsp?lang=&bldg_id=B000060681&unit_id=U001480433
        
        URL url = new URL("http://www.hkp.com.hk/unit/unit_tx.jsp?unit_id=U001480433");
        HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
        
        // direct connection is not allowed, unless setting the referrer
        httpConnection.setRequestProperty("Referer", "http://www.hkp.com.hk/");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }
}
