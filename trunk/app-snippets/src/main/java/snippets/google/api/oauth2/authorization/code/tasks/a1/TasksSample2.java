package snippets.google.api.oauth2.authorization.code.tasks.a1;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.Task;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TasksSample2 {
    public static void main(String[] args) throws IOException {

        // The clientId and clientSecret are copied from the API Access tab on the Google APIs Console
        String clientId = "";
        String clientSecret = "";
        String redirectUrl = "urn:ietf:wg:oauth:2.0:oob";
        Iterable<String> scope = Arrays.asList("https://www.googleapis.com/auth/tasks");

        String authorizationUrl = new GoogleAuthorizationCodeRequestUrl(clientId, redirectUrl, scope).build();
        System.out.println("Go to the following link in your browser:");
        System.out.println(authorizationUrl);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the authorization code?");
        String authorizationCode = in.readLine();

        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        
        
        GoogleTokenResponse response = new GoogleAuthorizationCodeTokenRequest(
                                        httpTransport, 
                                        jsonFactory,
                                        clientId, 
                                        clientSecret,
                                        authorizationCode,
                                        redirectUrl).execute();
        
        String accessToken = response.getAccessToken();
        String refreshToken = response.getRefreshToken();
        Long expiresInSeconds = response.getExpiresInSeconds();
        System.out.println("Access token: " + accessToken);
        System.out.println("Refresh token: " + refreshToken);
        System.out.println("Expires in seconds: " + expiresInSeconds);
      
        
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
        Tasks service = Tasks.builder(httpTransport, jsonFactory).setApplicationName("Goole Task Test").setHttpRequestInitializer(credential).build();

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
