package requestMethods;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostMethods {

    public static Response postRequest() {
        String jsonBody = "{\n" +
                "    image_id\": \"asf5\",\n" +
                "    \"sub_id\": \"my-user-1234\",\n" +
                "    \"value\": 1\n" +
                "}";

        return given()
                .header("x-api-key","DEMO-API-KEY")
                .body(jsonBody)
                .when()
                .post("/votes");
    }
}
