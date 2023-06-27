package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
   public RequestSpecification req;

    public RequestSpecification requestSpecification() throws FileNotFoundException {

        RestAssured.baseURI="https://rahulshettyacademy.com";
        PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));

         req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
                 .addFilter(RequestLoggingFilter.logRequestTo(log))
                         .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
         return req;

    }
}
