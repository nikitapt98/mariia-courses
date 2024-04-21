
package org.main.test;

import io.qameta.allure.*;
import io.restassured.RestAssured;

import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class APITests {
    public APITests() {
    }

    @Step("POST request - create a new user")
    @Description("Create new user")
    @Owner("Mariia Khorsun")
    @TmsLink("TC-0001")
    @Test
    public void createNewUser() {
        byte[] body;
        try {
            body = Files.readAllBytes(Path.of("src/main/java/org/main/resources/registeruserbody.json"));
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }

        this.addAttachment("userbody.json");
       RestAssured.given().spec(BaseTest.getRequestSpecification("https://reqres.in"))
               .body(body).when().post("/api/users", new Object[0])
               .then().spec(BaseTest.getResponseSpecification("https://reqres.in")).statusCode(201).log().all();
    }

    @Attachment
    public byte[] addAttachment(String fileName) {
        try {
            return Files.readAllBytes(Path.of("src/main/java/org/main/resources", fileName));
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    @Step("POST request - successful user registration")
    @Description("Register new user")
    @Owner("Mariia Khorsun")
    @TmsLink("TC-0002")
    @Test
    public void registerNewUser() {
        byte[] body;
        try {
            body = Files.readAllBytes(Path.of("src/main/java/org/main/resources/registeruserbody.json"));
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }

        this.addAttachment("registeruserbody.json");
        RestAssured.given().spec(BaseTest.getRequestSpecification("https://reqres.in"))
                .body(body).when().post("/api/register", new Object[0])
                .then().statusCode(200).log().all();
    }

    @Step("GET request - get a specific user")
    @Description("get user")
    @Owner("Mariia Khorsun")
    @TmsLink("TC-0003")
    @Test
    public void getSingleUser() {
        this.addAttachment("userbody.json");
        RestAssured.given().spec(BaseTest.getRequestSpecification("https://reqres.in"))
                .when().get("/api/users/2", new Object[0])
                .then().statusCode(200).log().all();
    }

    @Step("GET request - list of all users")
    @Description("get all users")
    @Owner("Mariia Khorsun")
    @TmsLink("TC-0004")
    @Test
    public void getAllUsers() {
        RestAssured.given().spec(BaseTest.getRequestSpecification("https://reqres.in"))
                .when().get("/api/users?page=2", new Object[0])
                .then().statusCode(200).log().all();
    }

    @Step("PUT request - update user info")
    @Description("put - update user info")
    @Owner("Mariia Khorsun")
    @TmsLink("TC-0005")
    @Test
    public void updUserInfo() {
        byte[] updateBody;
        try {
            updateBody = Files.readAllBytes(Path.of("src/main/java/org/main/resources/upduserbody.json"));
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }

        RestAssured.given().spec(BaseTest.getRequestSpecification("https://reqres.in"))
                .body(updateBody).when().put("/api/users/2", new Object[0]
                ).then().statusCode(200).log().all();
    }

    @Step("DELETE request - delete a specific user")
    @Description("delete user")
    @Owner("Mariia Khorsun")
    @TmsLink("TC-0006")
    @Test
    public void deleteUser() {
       RestAssured.given().spec(BaseTest.getRequestSpecification("https://reqres.in"))
               .when().delete("/api/users/2", new Object[0])
               .then().statusCode(204).log().all();
    }
}
