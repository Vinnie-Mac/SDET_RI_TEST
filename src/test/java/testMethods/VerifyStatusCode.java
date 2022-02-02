package testMethods;

import org.testng.asserts.SoftAssert;

public class VerifyStatusCode {

    /**
     * Verify the given status code against what is expected
     *
     * @param actualStatusCode   actual status code returned from api response
     * @param expectedStatusCode what status code is expected to be returned from api response
     */
    public void verifyStatusCode(int actualStatusCode, int expectedStatusCode) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, expectedStatusCode, "Assertion Failed: Status code was not as expected");
        softAssert.assertAll();
    }
}
