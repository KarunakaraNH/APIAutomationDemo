package stepDefinition;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResource;
import resources.TestDataBuild;
import resources.Utils;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utils {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data=new TestDataBuild();
    APIResource resource;
    static String placeId;


    @Given("addplace payload with {string} {string} {string}")
    public void addplace_payload_with(String name, String language, String address)  throws IOException {
    res=given().spec(requestSpecification())
        .body(data.addPlacePayLoad(name,language,address));
       // resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
     //   res= req.given().spec(requestSpecification).body(data.addPlacePayLoad(name,language,address));
    }


    @When("user calls {string} with {string} http request")
    public void user_calls_with_post_http_request(String resource,String method) {
      APIResource resourceAPI= APIResource.valueOf(resource);
        System.out.println(resourceAPI.getAPIResource());
      resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
      if(method.equalsIgnoreCase("POST")) {
          response = res.when().post(resourceAPI.getAPIResource());
      }
      else if(method.equalsIgnoreCase("GET")){
          response=res.when().get(resourceAPI.getAPIResource());
      }
    }
    @Then("the api call get success with status code {int}")
    public void the_api_call_get_success_with_status_code(Integer int1) {
     assertEquals(200,response.getStatusCode());
    }

    @Then("{string} in the response body is {string}")
    public void in_the_response_body_is(String keyvalue, String Expectedvalue) {
     //   APIResource ress= APIResource.valueOf(resource);
        assertEquals(getJsonPath(response,keyvalue),Expectedvalue);
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {

        // requestSpec
        placeId=getJsonPath(response,"place_id");
        res=given().spec(requestSpecification()).queryParam("place_id",placeId);
        user_calls_with_post_http_request(resource,"GET");
        String actualName=getJsonPath(response,"name");
        assertEquals(actualName,expectedName);


    }


    @Given("Delete play payload")
    public void delete_play_payload() throws IOException {
        given().spec(requestSpecification()).body(data.deletePlacePayLoad(placeId));
    }


}
