package stepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceResponse;
import pojo.GetPlace;
import resources.APIResource;
import resources.TestDataBuild;
import resources.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AddPlaceStepDefinition extends Utils{
    RequestSpecification reqspec;
    ResponseSpecification resonsepspec;
    Response response;
    TestDataBuild data=new TestDataBuild();
    String jsonResponse;
    ObjectMapper objectMapper=new ObjectMapper();;
    public static AddPlaceResponse addPlaceResponse;
    public static String place_id;
    public GetPlace getplace;
    APIResource resourceAPI;


    @Given("addplace payload with {string} {string} {string}")
    public void addplace_payload_with(String name, String language, String address) throws IOException {
        reqspec=given().spec(requestSpecification())
                .body(data.addPlacePayLoad(name,language,address)).log().all();
    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        resourceAPI = APIResource.valueOf(resource);
        System.out.println(resourceAPI.getAPIResource());
        resonsepspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        System.out.println("check point");
        if (method.equalsIgnoreCase("POST")) {
            response = reqspec.when().post(resourceAPI.getAPIResource());
            jsonResponse=response.getBody().asString();

        } else if (method.equalsIgnoreCase("GET")) {
            response = reqspec.when().get(resourceAPI.getAPIResource());
           jsonResponse= response.getBody().asString();
        }
    }

    @Then("the api call get success with status code {int}")
    public void the_api_call_get_success_with_status_code(int statuscode) {
        System.out.println("statuscode "+response.getStatusCode());
        assertEquals(statuscode,response.getStatusCode());
    }
    @Then("{string} in the response body is {string}")
    public void in_the_response_body_is(String keyvalue, String expected) throws JsonProcessingException {
        addPlaceResponse=objectMapper.readValue(jsonResponse,AddPlaceResponse.class);
        if(keyvalue.equals("status")){
            assertEquals(expected,addPlaceResponse.getStatus());
        }else{
            assertEquals(expected,addPlaceResponse.getScope());
        }


    }

  @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
         place_id= addPlaceResponse.getPlace_id();
         System.out.println("place_id "+place_id);
         reqspec=given().spec(requestSpecification()).when().queryParam("place_id",place_id);
         user_calls_with_http_request(resource,"GET");
         // ignoring unknown properties
         objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         GetPlace getplace= objectMapper.readValue(jsonResponse,GetPlace.class);
         String actualName=getplace.getName();
         System.out.println("actualName is " +actualName);
         System.out.println("expected name "+expectedName);
         assertEquals(expectedName,actualName);




    }


}
