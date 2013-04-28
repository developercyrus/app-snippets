package snippets.google.api.oauth2.authorization.code.tasks.a1;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.Task;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class ByAccessToken {
    public static void main(String[] args) throws IOException {
        String url = "https://accounts.google.com/o/oauth2/token";
        String client_id = "";
        String client_secret = "";
        String refresh_token = "";
        String grant_type = "refresh_token";
        
        List<BasicNameValuePair> data = new ArrayList<BasicNameValuePair>();  
        data.add(new BasicNameValuePair("client_id", client_id));  
        data.add(new BasicNameValuePair("client_secret", client_secret));  
        data.add(new BasicNameValuePair("refresh_token", refresh_token));
        data.add(new BasicNameValuePair("grant_type", grant_type));
        
        HttpClient client = new DefaultHttpClient();  
        HttpPost httppost = new HttpPost(url);  
        httppost.setEntity(new UrlEncodedFormEntity(data, HTTP.UTF_8)); 
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String respondBody = client.execute(httppost, responseHandler);
        System.out.println(respondBody); 
        
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(respondBody);  
        String accessToken = jsonObject.getString("access_token");
        System.out.println(accessToken);

        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();                
        //GoogleCredential credential = new GoogleCredential().setRefreshToken(refreshToken).setAccessToken(accessToken);
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
 
        Tasks service = Tasks.builder(httpTransport, jsonFactory)
                            .setApplicationName("Goole Task Test")
                            .setHttpRequestInitializer(credential)                            
                            .build();

        TaskLists taskLists = service.tasklists().list().execute();                
        for (TaskList taskList : taskLists.getItems()) {
            System.out.println("task list title: " + taskList.getTitle());
            com.google.api.services.tasks.model.Tasks tasks = service.tasks().list(taskList.getId()).execute();

            while (true) {
                for (Task task : tasks.getItems()) {
                    System.out.println("task id: " + task.getId());
                    System.out.println("task title: " + task.getTitle());
                    System.out.println(" >> parent id: " + task.getParent());
                    System.out.println(" >> status: " + task.getStatus());
                    System.out.println(" >> notes: " + task.getNotes());
                    System.out.println(" >> due date: " + task.getDue());
                    System.out.println(" >> selflink: " + task.getSelfLink());
                    System.out.println(" >> type: " + task.getKind());
                    System.out.println(" >> completed date: " + task.getCompleted());
                    System.out.println(" >> updated date: " + task.getUpdated());
                    System.out.println(" >> deleted : " + task.getDeleted());
                    System.out.println(" >> hidden : " + task.getHidden());
                    System.out.println(" >> position : " + task.getPosition());
                    System.out.println(" >> ETag: " + task.getEtag());
                    System.out.println("");
                }

                String pageToken = tasks.getNextPageToken();
                if (pageToken != null && !pageToken.equalsIgnoreCase("")) {
                    tasks = service.tasks().list(taskList.getId()).setPageToken(pageToken).execute();
                }
                else {
                    break;
                }
            }

        }
    }
}
