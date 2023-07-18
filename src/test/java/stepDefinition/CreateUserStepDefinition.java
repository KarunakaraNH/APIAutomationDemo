package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import resources.APIResource;
import resources.TestDataBuild;
import resources.Utils;

public class CreateUserStepDefinition extends Utils {

    RequestSpecification reqspec;
    ResponseSpecification respspec;
    Response response;
    TestDataBuild data=new TestDataBuild();
    static String user_id;



    @Given("crate user payload with {string} and {string}")
    public void crate_user_payload_with_and(String name, String job) throws Exception {
            reqspec=RestAssured.given().spec(createUserRequestSpecification())
                    .body(data.createUserPayload(name,job)).log().all();
    }
    @When("User hit {string} api with http {string} request")
    public void user_hit_api_with_http_request(String resource, String method) {

        APIResource resourceAPI= APIResource.valueOf(resource);
        System.out.println(resourceAPI.getAPIResource());
        respspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        System.out.println("check point");
        if(method.equalsIgnoreCase("POST")) {
            response = reqspec.when().post(resourceAPI.getAPIResource());
        }
        else if(method.equalsIgnoreCase("GET")){
            response=reqspec.when().get(resourceAPI.getAPIResource());
        }

    }
    @Then("api call get success with status code {int}")
    public void api_call_get_success_with_status_code(Integer statuscode) {
        System.out.println("statuscode is"+response.statusCode());
        Assert.assertEquals(statuscode,response.getStatusCode());
        response.then().body("id", Matchers.notNullValue());



    }
   @Then("Validate user got created and map to {string} with {string} api")
    public void validate_user_got_created_and_map_to_with_api(String string, String string2) {

    }

}
