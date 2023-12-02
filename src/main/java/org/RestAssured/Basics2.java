package org.RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static Files.Payload.add;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics2 {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com/";        //SET BASE URL

        //given - all input fields
        //when - submit the api (Resource, HTTP methods)
        //then - validate the response

       String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(add())                //ADD PAYLOAD FROM A SEPARATE CLASS
                .when().post("/maps/api/place/add/json")        //SUBMIT HTTP REQUEST
                .then().log().all().assertThat().statusCode(200)       //VALIDATE THAT STATUS CODE IS 200
                .body("scope", equalTo("APP"))              //MATCHING JSON RESPONSE WITH HAMCREST MATCHERS
                .header("Server","Apache/2.4.52 (Ubuntu)")     //MATCHING HEADER IN RESPONSE
                .extract().response().asString();               //EXTRACT JSON RESPONSE AND STORE IT IN A STRING

        System.out.println(response);

        JsonPath js = new JsonPath(response);       //FOR PARSING JSON STORED AS A STRING
        String placeId = js.getString("place_id");      //EXTRACTING PLACE ID AND STORING IT IN A STRING
        System.out.println(placeId);        //PRINTING THE PLACE ID

        //ADD PLACE
        //UPDATE PLACE WITH NEW ADDRESS
        //GET PLACE TO VALIDATE IF NEW ADDRESS IS PRESENT OR NOT




    }
}
