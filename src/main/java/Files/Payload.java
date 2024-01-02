package Files;

import io.restassured.path.json.JsonPath;

public class Payload {

    public static String add() {
        return "{\n" +
                "    \"location\": {\n" +
                "        \"lat\": -38.383494,\n" +
                "        \"lng\": 33.427362\n" +
                "    },\n" +
                "    \"accuracy\": 50,\n" +
                "    \"name\": \"Frontline house\",\n" +
                "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "    \"address\": \"29, side layout, cohen 09\",\n" +
                "    \"types\": [\n" +
                "        \"shoe park\",\n" +
                "        \"shop\"\n" +
                "    ],\n" +
                "    \"website\": \"http://google.com\",\n" +
                "    \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String update(String placeId) {
        return "{\n" +
                "    \"place_id\": \"" + placeId + "\",\n" +
                "    \"address\": \"70 Summer walk, USA\",\n" +
                "    \"key\": \"qaclick123\"\n" +
                "}";

    }

    public static String jsonPath(String response, String path) {
        JsonPath js = new JsonPath(response);
        return js.getString(path);
    }
}
