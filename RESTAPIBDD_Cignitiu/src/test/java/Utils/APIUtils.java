package Utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APIUtils
{

    private static final String BASE_URL = "https://api.restful-api.dev/objects";

    // Method to get the response as a JsonPath object
    public static JsonPath getJsonResponse(String endpoint)
    {
        RestAssured.baseURI = BASE_URL;
        String responseString = RestAssured.given().get(endpoint).then().statusCode(200).extract().response().asString();
        return new JsonPath(responseString);
    }

    // Overloaded method to get the response as a string
    public static String getResponseString(String endpoint) {
        RestAssured.baseURI = BASE_URL;
        return RestAssured.given().get(endpoint).then().statusCode(200).extract().response().asString();
    }
}
