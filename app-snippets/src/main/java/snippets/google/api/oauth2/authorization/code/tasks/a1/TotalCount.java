package snippets.google.api.oauth2.authorization.code.tasks.a1;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.Task;

import java.io.IOException;

public class TotalCount {
    public static void main(String[] args) throws IOException {
        int totalCount = 0;
        int completedCount = 0;;
        
        String accessToken = "";

        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();                
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
        
        Tasks service = Tasks.builder(httpTransport, jsonFactory).setApplicationName("Goole Task Test").setHttpRequestInitializer(credential).build();
        String taskID = "MDkwNjk0OTkzMzIzMzY2OTk1MjY6MDow";
        com.google.api.services.tasks.model.Tasks tasks = service.tasks().list(taskID).execute();

        while (true) {
            for (Task task : tasks.getItems()) {
                totalCount++;
                if (task.getCompleted()!= null) {
                    completedCount++;
                }
            }

            String pageToken = tasks.getNextPageToken();
            if (pageToken != null && !pageToken.equalsIgnoreCase("")) {
                tasks = service.tasks().list(taskID).setPageToken(pageToken).execute();
            }
            else {
                break;
            }
        }
        System.out.println("total count = " + totalCount);
        System.out.println("completed count = " + completedCount);
    }
}
