package snippets.linkedin.linkedinj.a1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.Parameter;
import com.google.code.linkedinapi.client.constant.LanguageCodes;
import com.google.code.linkedinapi.client.constant.RelationshipCodes;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.schema.Facet;
import com.google.code.linkedinapi.schema.FacetType;
import com.google.code.linkedinapi.schema.PeopleSearch;
import com.google.code.linkedinapi.schema.Person;

public class ByAccessTokenPeopleSearch {
    public static void main(String[] args) throws IOException {
        String consumerKeyValue = "";
        String consumerSecretValue = "";
        String accessToken = "";
        String accessTokenSecret = "";
        

        LinkedInAccessToken linkedInAccessToken = new LinkedInAccessToken(accessToken, accessTokenSecret);
        final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(consumerKeyValue, consumerSecretValue);
        final LinkedInApiClient client = factory.createLinkedInApiClient(linkedInAccessToken);
        
        /*
           
            http://www.linkedin.com/search/fpsearch?company=Liberty International Insurance&currentCompany=CP&searchLocationType=I&countryCode=hk&keepFacets=keepFacets&page_num=1&search=&pplSearchOrigin=MDYS&viewCriteria=1&sortCriteria=R&facetsOrder=CC,N,G,I,PC,ED,L,FG,TE,FA,SE,P,CS,F,DR&redir=redir        
        
        */
        
        Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
        searchParameters.put(SearchParameter.KEYWORDS, "");
        searchParameters.put(SearchParameter.FIRST_NAME, "");
        searchParameters.put(SearchParameter.CURRENT_COMPANY, "");
        searchParameters.put(SearchParameter.COMPANY_NAME, "Liberty International Insurance");
        searchParameters.put(SearchParameter.TITLE, "");
        searchParameters.put(SearchParameter.CURRENT_TITLE, "");
        searchParameters.put(SearchParameter.COUNTRY_CODE, "hk");

        List<Parameter<FacetType, String>> facets = new ArrayList<Parameter<FacetType,String>>();
        facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.OUT_OF_NETWORK_CONNECTIONS));
        facets.add(new Parameter<FacetType, String>(FacetType.NETWORK, RelationshipCodes.SECOND_DEGREE_CONNECTIONS));
        facets.add(new Parameter<FacetType, String>(FacetType.LANGUAGE, LanguageCodes.ENGLISH));
        PeopleSearch peopleSearch = client.searchPeople(
                                    searchParameters
                                    , EnumSet.of(
                                        ProfileField.FIRST_NAME
                                        , ProfileField.LAST_NAME
                                        , ProfileField.ID
                                        , ProfileField.HEADLINE
                                    )
                                    , EnumSet.of(
                                        FacetField.NAME
                                        , FacetField.CODE
                                        , FacetField.BUCKET_NAME
                                        , FacetField.BUCKET_CODE
                                        , FacetField.BUCKET_COUNT
                                    )
                                    , facets);
        

        System.out.println("================================");
        System.out.println("Total search result:" + peopleSearch.getPeople().getCount());
        for (Person person : peopleSearch.getPeople().getPersonList()) {
            System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());
        }

        System.out.println("================================");
        System.out.println("Total facet result:" + peopleSearch.getFacets().getTotal());
        for (Facet facet : peopleSearch.getFacets().getFacetList()) {
            System.out.println(facet.getName() + ":" + facet.getCode());
        }
    }
}
