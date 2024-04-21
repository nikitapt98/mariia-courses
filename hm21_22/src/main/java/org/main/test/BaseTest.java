
package org.main.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    public BaseTest() {
    }

    @BeforeAll
    protected static void initTests() {
        RestAssured.baseURI = "https://reqres.in";
    }

    protected static RequestSpecification getRequestSpecification(String host) {
        return (new RequestSpecBuilder()).setContentType(ContentType.JSON).setBaseUri(host).build();
    }

    protected static ResponseSpecification getResponseSpecification(String host) {
        return (new ResponseSpecBuilder()).setDefaultParser(Parser.JSON).build();
    }
}
