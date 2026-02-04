package by.mattioli.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SearchService {
    private final String URL_SEARCH = "https://mattioli.by/";
    private Response response;

    private Map<String, String> getQueryParams() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("c", "slam%3Asearch.elastic");
        queryParams.put("action", "ajaxSearch");
        queryParams.put("mode", "class");
        return queryParams;
    }

    public void doRequest() {
        response = given()
                .queryParams(getQueryParams())
                .when()
                .get(URL_SEARCH);
    }

    public int getStatusCode() {
        return response.then().extract().statusCode();
    }

    public String getBody() {
        return response.then().extract().body().asPrettyString();
    }
}
