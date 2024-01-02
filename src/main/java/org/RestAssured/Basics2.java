package org.RestAssured;

import io.restassured.RestAssured;
import org.testng.Assert;

import static Files.Payload.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics2 {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com/";        //SET BASE URL

        //given - all input fields
        //when - submit the api (Resource, HTTP methods)
        //then - validate the response
        String address = "29, side layout, cohen 09";
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(add())                //ADD PAYLOAD FROM A SEPARATE CLASS
                .when().post("/maps/api/place/add/json")        //SUBMIT HTTP REQUEST
                .then().log().all().assertThat().statusCode(200)       //VALIDATE THAT STATUS CODE IS 200
                .body("scope", equalTo("APP"))              //MATCHING JSON RESPONSE WITH HAMCREST MATCHERS
                .header("Server", "Apache/2.4.52 (Ubuntu)")     //MATCHING HEADER IN RESPONSE
                .extract().response().asString();               //EXTRACT JSON RESPONSE AND STORE IT IN A STRING

        System.out.println(response);

  /*      JsonPath js = new JsonPath(response);       //FOR PARSING JSON STORED AS A STRING
        String placeId = js.getString("place_id");    */  //EXTRACTING PLACE ID AND STORING IT IN A STRING
       String placeId = jsonPath(response,"place_id");

        System.out.println(placeId);        //PRINTING THE PLACE ID

        //ADD PLACE
        //UPDATE PLACE WITH NEW ADDRESS
        //GET PLACE TO VALIDATE IF NEW ADDRESS IS PRESENT OR NOT

        //UPDATE PLACE
        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(update(placeId))
                .when().log().all().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200);

        //GET PLACE

        String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200)        //HAMCREST ASSERTION
                .extract().asString();

       String newAddress = jsonPath(getResponse,"address");         //FETCH ADDRESS VALUE FROM JSON STRING
        System.out.println(newAddress);

        //USING TEST NG ASSERTION
        Assert.assertEquals(newAddress,"70 Summer walk, USA");

    }
}
