package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPI {
    protected String baseURI;
    protected Response apiResponse;
    protected String responseBody;
    protected int expectedStatusCode;
    protected RequestSpecBuilder requestSpecBuilder;
    protected RequestSpecification requestSpecification;
    protected ResponseSpecBuilder responseSpecBuilder;
    protected ResponseSpecification responseSpecification;

    public BaseAPI(String baseURI) {
        this.baseURI = baseURI;
        requestSpecBuilder=new RequestSpecBuilder();
        responseSpecBuilder=new ResponseSpecBuilder();
    }

    public Response getApiResponse() {
        return apiResponse;
    }

    public int getExpectedStatusCode() {
        return expectedStatusCode;
    }


}
