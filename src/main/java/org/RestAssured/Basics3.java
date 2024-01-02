package org.RestAssured;

import Files.JsonResponse;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;

import static Files.JsonResponse.response;

public class Basics3 {
    public static void main(String[] args) {

        JsonPath jp = new JsonPath(response());        //FETCH THE JSON RESPONSE AS A STRING
        String website = jp.get("dashboard.website");
        System.out.println(website);

        //GET THE SIZE OF THE COURSES ARRAY
        
    }
}
