package org.RestAssured;

import Files.Payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Basics2 {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com/";        //SET BASE URL

        //given - all input fields
        //when - submit the api (Resource, HTTP methods)
        //then - validate the response

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.add()).when().post("/maps/api/place/add/json")        //SUBMIT HTTP REQUEST
                .then().log().all().assertThat().statusCode(200);       //VALIDATE THAT STATUS CODE IS 200

    }
}
