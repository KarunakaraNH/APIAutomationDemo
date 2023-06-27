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
import resources.TestDataBuild;
import resources.Utils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.requestSpecification;

public class StepDefinition extends Utils {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data=new TestDataBuild();



    @Given("add book payload")
    public void add_book_payload() {
        resspec= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res= req.given().spec(requestSpecification).body(data.addPlacePayLoad());




    }
    @When("user calls {string} with post http request")
    public void user_calls_with_post_http_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the api call get success with status code {int}")
    public void the_api_call_get_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in the response body is {string}")
    public void in_the_response_body_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
