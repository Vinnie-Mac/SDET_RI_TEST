package stepDefinitions;

import connectionUtils.ConnectionUtils;
import helpers.MappingHelpers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.ModelPackage;
import org.testng.Assert;
import requestMethods.GetMethods;
import testMethods.VerifyStatusCode;

import java.net.HttpURLConnection;


public class StepDefinitions {
    VerifyStatusCode verifyStatusCode = new VerifyStatusCode();
    private Response response;

    @Given("the endpoint exists")
    public void theEndpointExists() {
        Assert.assertEquals(HttpURLConnection.HTTP_MOVED_TEMP, ConnectionUtils.getResponseCodeForURLConnection());
    }

//    @When("I request to get clients")
//    public void iRequestToGetClients() {
//        response = GetMethods.getResponse("/clients");
//    }

//    @When("I get the android language from clients endpoint")
//    public void iGetTheAndroidLanguageFromClientsEndpoint(){
//        response = GetMethods.getResponse("/clients/android");
//    }

    @Then("the status code is equal to {int}")
    public void theStatusCodeIsEqualTo(int expectedStatusCode) {
        verifyStatusCode.verifyStatusCode(response.getStatusCode(), 200);
    }

    @Then("the description field reads {string}")
    public void theStatusCodeIsEqualTo(String expectedDescription) {
        ModelPackage modelPackage = MappingHelpers.mapModelPackageNode(response.body().asString());
        Assert.assertEquals(modelPackage.getDescription(), expectedDescription);
    }
}
