package stepDefinitions;

import jsonExtraction.extractusingJsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public  class stepDefinition_BDD {

    private Response response;
    extractusingJsonPath jsonExtractObj = new extractusingJsonPath();


    @Given("GET call to endpoint")
    public void getCallToEndpoint() {
        RestAssured.baseURI = "https://api.restful-api.dev";
        given().get("/objects").then().statusCode(200);

    }

    @When("request is success")
    public void requestIsSuccess()
    {
        System.out.println("The response is succesfully validated");
    }
    @Then("get phone with lowest cost")
    public void getPhoneWithLowestCost()
    {
        //call to method where price, id and name is retrieved from json
        jsonExtractObj.extractJsonPrice();
    }
}













