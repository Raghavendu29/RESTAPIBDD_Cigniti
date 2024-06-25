package jsonExtraction;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.util.*;
import static io.restassured.path.json.JsonPath.given;

public  class extractusingJsonPath
{
    private static String data_id ;
    private static String data_name ;
    private static double data_price;
    List<jsonInfo> jsonList = new ArrayList<>(); ;
    
    @Test
    public void extractJsonPrice()
    {

        RestAssured.baseURI = "https://api.restful-api.dev";
        String responseString = RestAssured.given().get("/objects").then().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(responseString);                                                                                                 //declaring list to store the values
                                                                                                                                                    List<Map<String, String>> lstJson = JsonPath.from(responseString).get("list");
                                                                                                                                                    //to fetch the price node
        String jsonString_price = responseString;
        //using Jackson dependency
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonString_price);
            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode element = elements.next();
                String id = element.get("id").asText();
                String name = element.get("name").asText();
                JsonNode dataNode = element.get("data");

                if (dataNode != null) {
                    JsonNode priceNode = dataNode.get("price");
                    if (priceNode != null) {
                        double price = priceNode.asDouble();
                        jsonList.add(new jsonInfo(id, name, price));
                    } else if (dataNode.get("Price") != null) {
                        double price = dataNode.get("Price").asDouble();
                        jsonList.add(new jsonInfo(id, name, price));
                    }
                }
            }
            jsonList.sort(Comparator.comparingDouble(jsonInfo::getPrice));
            // Print the list after getting sorted
            jsonList.forEach(System.out::println);
            jsonInfo lowestPriceProduct = jsonList.get(0);
            System.out.println("The lowest price of product is" + " " + lowestPriceProduct.getPrice() + " "   +   "having the name as" +  " " +lowestPriceProduct.getName() +  " " + "and id:" +lowestPriceProduct.getId() );
        }
         catch( Exception e)
            {
                e.printStackTrace();
            }

    }
    }


















