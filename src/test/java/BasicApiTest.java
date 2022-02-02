import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Votes;
import org.junit.Assert;
import org.testng.annotations.Test;
import requestMethods.GetMethods;
import requestMethods.PostMethods;
import sun.rmi.transport.ObjectTable;

import java.util.List;

public class BasicApiTest extends BaseTest {

    //////////////////////////////////////// PRACTICE SECTION ////////////////////////////////////////

//    @Test
//    public void verifyStatusCode() {
//        Response response = GetMethods.getResponse("/clients");
//        response.prettyPrint();
//        verifyStatusCode.verifyStatusCode(response.getStatusCode(), 200);
//
//        System.out.println(GetMethods.getClients(GetMethods.getJsonPath(response)));
//    }
//
//    @Test
//    public void verifyAndroidClientLanguageDetails() throws JsonProcessingException{
//        Response response = GetMethods.getResponse("/clients/android");
//        response.prettyPrint();
//        verifyStatusCode.verifyStatusCode(response.getStatusCode(), 200);
//
//        models.ModelPackage modelPackage = helpers.MappingHelpers.mapModelPackageNode(response.body().asString());
//        System.out.println("\n Model Package Description: " + modelPackage.getDescription());
//    }



    //////////////////////////////////////// INTERVIEW SECTION ////////////////////////////////////////

    @Test
    public void interviewTestOne() {
        Response response = GetMethods.getResponse();
        response.prettyPrint();
        Assert.assertTrue(response.body().asString().length() > 0);
        verifyStatusCode.verifyStatusCode(response.getStatusCode(), 200);

    }

    @Test
    public void interviewTestTwo() {
        Response response = GetMethods.getResponse();

        ObjectMapper objMap = new ObjectMapper();
        List<Votes> responseOfVotes = objMap.convertValue(response.body().asString(), new TypeReference<List<Votes>>(){});
        Votes firstVote = responseOfVotes.get(0);

        Assert.assertEquals(firstVote.getId(), 31098);
        verifyStatusCode.verifyStatusCode(response.getStatusCode(), 200);
    }

    @Test
    public void interviewTestThree() {
        Response response = PostMethods.postRequest();
        response.prettyPrint();
        verifyStatusCode.verifyStatusCode(response.getStatusCode(), 200);
        Assert.assertEquals(response.body().jsonPath().get("message"), "SUCCESS");
    }
}
