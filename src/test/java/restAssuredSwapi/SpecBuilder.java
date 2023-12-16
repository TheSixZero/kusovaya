package restAssuredSwapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {


    RequestSpecification  requestSpec = new RequestSpecBuilder().
            setBaseUri("https://swapi.dev").
            setContentType(ContentType.JSON).
            build();


    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType(ContentType.JSON).
            build();
}
