package snippets.google.api.oauth2.service.account.tasks.a1;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.Task;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;

public class TasksSample {
    public static void main(String[] args) throws IOException, GeneralSecurityException {

        String serviceEmailAccount = "";        
        Iterable<String> scope = Arrays.asList("https://www.googleapis.com/auth/tasks");
        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        String path = TasksSample.class.getResource("privatekey.p12").getFile();
        
        
        GoogleCredential credential = new GoogleCredential.Builder()
                                        .setTransport(httpTransport)
                                        .setJsonFactory(jsonFactory)
                                        .setServiceAccountId(serviceEmailAccount)
                                        .setServiceAccountScopes(scope)
                                        .setServiceAccountPrivateKeyFromP12File(new File(path))
                                        .build();
          
        Tasks service = Tasks.builder(httpTransport, jsonFactory).setApplicationName("Google Task Test").setHttpRequestInitializer(credential).build();

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
