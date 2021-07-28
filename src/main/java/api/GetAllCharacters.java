package api;

import org.json.JSONArray;
import POJOS.SeriesCharacter;
import org.testng.Assert;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class GetAllCharacters extends BaseAPI{

    String path ="/characters/";

    public GetAllCharacters(String baseURI) {
        super(baseURI);
    }

    public void createRequest(){
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(path);
        requestSpecification=requestSpecBuilder.build();
    }

    public void executeRequest(){
        apiResponse = given().spec(requestSpecification).get();
    }

    public void validateResponse(){
        Assert.assertEquals(apiResponse.getStatusCode(),200);
    }

    public void printAllCharacters(){
        String responseBody =  apiResponse.getBody().asString();
        JSONArray JSONResponseBody;

        SeriesCharacter[] seriesCharacters = apiResponse.body().as(SeriesCharacter[].class);
        Arrays.stream(seriesCharacters).forEach(person -> {
            System.out.println("Character Name : \""+ person.getName()+"\"");
            System.out.println("Portrayed: \""+ person.getPortrayed()+"\"");
            System.out.println("\n-----------------------\n");

        });

    }
}
