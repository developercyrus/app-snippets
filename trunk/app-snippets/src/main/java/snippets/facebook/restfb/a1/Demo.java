package snippets.facebook.restfb.a1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Comment;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Post.Comments;
import com.restfb.types.Post.Likes;
import com.restfb.types.User;

public class Demo {
    public static void main(String[] args) throws IOException {  
        
        /*         
            1. Send http request by https://graph.facebook.com/oauth/authorize?client_id=[API Key]&redirect_uri=http://www.facebook.com/connect/login_success.html&scope=publish_stream,offline_access,create_event

            2. Facebook will redirect you to https://www.facebook.com/connect/login_success.html?code=[AUTHORIZATION CODE]
        
            3. Send http request by https://graph.facebook.com/oauth/access_token?client_id=[API Key]&redirect_uri=http://www.facebook.com/connect/login_success.html&client_secret=[APP SECRET]&code=[AUTHORIZATION CODE]
         */
        
        
        /*
         
             https://developers.facebook.com/tools/access_token/
             
            Issued:   1336669200 (55 minutes left)
            Expires:  1336672800 (about an hour left)
         
         */
        
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\tmp.txt"), "UTF8"));
        String accessToken = "";        
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken);        
        User user = facebookClient.fetchObject("me", User.class);
        System.out.println("User name: " + user.getName());        
        
        Connection<Post> homes = facebookClient.fetchConnection("me/home", Post.class);
        while (homes.hasNext()) {
            for (Post post : homes.getData()) {
                Likes likes = post.getLikes();
                if (likes != null) {
                    List<NamedFacebookType> likesData = likes.getData();
                    for (NamedFacebookType like : likesData) {
                        if (like.getId().equals("519662604")) {
                            System.out.println(post);
                            out.append(post.toString()).append("\r\n");
                        }
                    }
                }
                
                Comments comments = post.getComments();
                if (comments != null) {
                    List<Comment> commentsData = comments.getData();
                    for (Comment comment : commentsData) {
                        if (comment.getFrom().getId().equals("519662604")) {
                            String output = comment.getMessage() + " at " + comment.getCreatedTime() + " on " + post.getFrom().getName() + " " + post.getLink();
                            System.out.println(output);
                            out.append(output).append("\r\n");
                        }
                    }
                }
            }
            
            String nextPageUrl = homes.getNextPageUrl();
            //System.out.println(nextPageUrl);
            homes = facebookClient.fetchConnectionPage(nextPageUrl, Post.class);            
        }
        
        out.flush();
        out.close(); 
    }
}
