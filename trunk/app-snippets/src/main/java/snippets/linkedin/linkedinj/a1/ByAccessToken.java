package snippets.linkedin.linkedinj.a1;

import java.io.IOException;
import java.util.EnumSet;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.schema.Person;

public class ByAccessToken {
    public static void main(String[] args) throws IOException {
        String consumerKeyValue = "";
        String consumerSecretValue = "";
        String accessToken = "";
        String accessTokenSecret = "";
        

        LinkedInAccessToken linkedInAccessToken = new LinkedInAccessToken(accessToken, accessTokenSecret);
        final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
        final LinkedInApiClient client = factory.createLinkedInApiClient(linkedInAccessToken);
        
        Person profile = client.getProfileForCurrentUser(EnumSet.of(ProfileField.ID));
        Person userprofile = client.getProfileById(profile.getId(), EnumSet.of(
                                                                        ProfileField.FIRST_NAME
                                                                        ,ProfileField.LAST_NAME
                                                                        ,ProfileField.HEADLINE
                                                                        ,ProfileField.INDUSTRY
                                                                        ,ProfileField.API_STANDARD_PROFILE_REQUEST
                                                                        ,ProfileField.PICTURE_URL
                                                                        ,ProfileField.PUBLIC_PROFILE_URL));
        
        System.out.println("CurrentUsers Profile-Id >> "+profile.getId());        
        System.out.println("PersonID:" + userprofile.getId()); 
        System.out.println("Name:"+ userprofile.getFirstName()+ " " + userprofile.getLastName()); 
        System.out.println("Headline:" + userprofile.getHeadline()); 
        System.out.println("API Request:" + userprofile.getApiStandardProfileRequest()); 
        System.out.println("Industry:" + userprofile.getIndustry()); 
        System.out.println("Picture:" + userprofile.getPictureUrl());
        System.out.println("Public URL:" + userprofile.getPublicProfileUrl());
    }
}
