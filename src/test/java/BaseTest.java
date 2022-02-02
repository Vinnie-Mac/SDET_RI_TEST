import io.restassured.http.ContentType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testMethods.VerifyStatusCode;
import restAssuredUtil.RestAssuredUtil;

public class BaseTest {
    RestAssuredUtil restAssuredUtil = new RestAssuredUtil();
    VerifyStatusCode verifyStatusCode = new VerifyStatusCode();


    /**
     * Initialise API uri and content type before the tests begin
     */
    @BeforeClass
    public void setup() {
        restAssuredUtil.setBaseURI();
        restAssuredUtil.setBasePath();
        restAssuredUtil.setContentType(ContentType.JSON);
    }

    /**
     * Do some clear up after the tests
     */
    @AfterClass
    public void afterTest() {
        restAssuredUtil.resetBasePath();
        restAssuredUtil.resetBaseURI();
    }
}
