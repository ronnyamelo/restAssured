package api;

import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetAndPrintCharacterInfo extends BaseAPI{

    String path ="/characters/?name={characterName}";
    String characterName;
    String birthday;
    JSONArray JSONResponseBody;

    public GetAndPrintCharacterInfo(String baseURI) {
        super(baseURI);
    }

    public void setCharacterName(String name) {
        this.characterName = name;
    }

    public void createRequest(){
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(path);
        requestSpecBuilder.addPathParam("characterName",characterName);
        requestSpecification=requestSpecBuilder.build();
    }

    public void validateResponse(){
        String walterBirthday = "09-07-1958";
        responseBody = apiResponse.getBody().asString();

        Assert.assertEquals(apiResponse.getStatusCode(),200);


        try {
            JSONResponseBody  = new JSONArray(responseBody);

        String responseBirthday = JSONResponseBody.getJSONObject(0).getString("birthday");
        Assert.assertEquals(responseBirthday,walterBirthday);
        }

        catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    public void executeRequest(){
        apiResponse = given().spec(requestSpecification).get();
    }

    public void printCharacterInformation(){

        try{
            birthday = JSONResponseBody.getJSONObject(0).getString("birthday");
            System.out.println("\nCharacters name is : "+JSONResponseBody.getJSONObject(0).getString("name"));
            System.out.println("\nCharacters Birthday is : "+birthday);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
