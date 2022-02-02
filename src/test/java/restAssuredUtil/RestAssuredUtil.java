package restAssuredUtil;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class RestAssuredUtil {

    /**
     *
     * @return
     */
    public static String getBaseURIString() {
        return "http://generator.swagger.io/";
    }

    /**
     * Sets Base URI
     */
    public static void setBaseURI() {
//        Practice API Base URI
//        RestAssured.baseURI = "http://generator.swagger.io/";


//        Interview API Base URI
        RestAssured.baseURI = "https://api.thecatapi.com/";
    }

    /**
     * Sets Base URI
     */
    public static void setHeader() {
//        Practice API Base URI
//        RestAssured.baseURI = "http://generator.swagger.io/";


//        Interview API Base URI
        RestAssured.given().header("", "");
    }

    /**
     * Sets base path
     */
    public static void setBasePath() {
//        Practice API Base Path
//        RestAssured.basePath = "api";


//        Practice API Base Path
        RestAssured.basePath = "v1";
    }

    /**
     * Reset Base URI (for the after test)
     */
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    /**
     * Reset base path
     */
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    /**
     * Sets ContentType if in need of overriding the before step
     *
     * @param Type
     */
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }
}