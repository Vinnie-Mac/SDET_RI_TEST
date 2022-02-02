package requestMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class GetMethods {
    /**
     * Returns response by given path
     *
     * @param
     * @return
     */
    public static Response getResponse() {
        return given()
                .header("x-api-key","DEMO-API-KEY")
                .when()
                .get("/votes");
    }

//    /**
//     * Returns response object
//     *
//     * @return
//     */
//    public static Response getResponse() {
//        return given()
//                .header("", "")
//                .cookie("")
//                .pathParam("", "")
//                .when()
//                .get();
//    }

    /**
     * Get the clients array back from the API itself. Array object necessary as that is what is in JSON response
     * @param jsonPath
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> getClients(@NotNull JsonPath jsonPath) {
        return jsonPath.get();
    }

    /**
     * Get the specific language model package value from the JSON response
     * @param jsonPath
     * @param <T>
     * @return
     */
    public <T> String getClientsLanguageModelPackage(@NotNull JsonPath jsonPath) {
        return jsonPath.get("modelPackage.opt");
    }

    /**
     * Get the specific language model package value from the JSON response
     * @param jsonPath
     * @param <T>
     * @return
     */
    public <T> ArrayList<T> getClientsLibrary(@NotNull JsonPath jsonPath) {
        return jsonPath.get("library");
    }

    /**
     * Returns the JsonPath object of a given response object
     *
     * @param response the response object as a result of a given api request
     * @return         the json path of the given response object
     */
    public static JsonPath getJsonPath(Response response) {
        String json = response.asString();
        return new JsonPath(json);
    }
}
