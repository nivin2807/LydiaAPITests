package Lydia.LydiaAPI;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIClient {

    private static final String BASE_URL = "https://reqres.in/api";

    public Response post(String endpoint, Object body) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .post(BASE_URL + endpoint);
    }

    public Response get(String endpoint) {
        return RestAssured
                .given()
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .get(BASE_URL + endpoint);
    }
}
