package snippets.linkedin.linkedinj.a1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.Person;

public class OAuthAuthenticationExample {

    public static void main(String[] args) throws IOException {
        
        /*
         * https://www.linkedin.com/secure/developer
         * 
         */
        
        final String consumerKeyValue = "";
        final String consumerSecretValue = "";
        final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(consumerKeyValue, consumerSecretValue);

        System.out.println("Fetching request token from LinkedIn...");

        LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();

        String authUrl = requestToken.getAuthorizationUrl();
        System.out.println("Request token: " + requestToken.getToken());
        System.out.println("Token secret: " + requestToken.getTokenSecret());
        System.out.println("Expiration time: " + requestToken.getExpirationTime());
        System.out.println("Now visit:\n" + authUrl + "\n... and grant this app authorization");
        System.out.println("Enter the PIN code and hit ENTER when you're done:");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pin = br.readLine();

        System.out.println("Fetching access token from LinkedIn...");

        LinkedInAccessToken accessToken = oauthService.getOAuthAccessToken(requestToken, pin);

        System.out.println("Access token: " + accessToken.getToken());
        System.out.println("Token secret: " + accessToken.getTokenSecret());

        final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
        final LinkedInApiClient client = factory.createLinkedInApiClient(accessToken);
        
        System.out.println("Fetching profile for current user.");

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