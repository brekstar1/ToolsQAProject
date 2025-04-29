package services;

import client.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class CommonService {

    public Response post(Map<String, String> requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        return performRequest("POST", requestSpecification, endpoint);
    }

    public Response get(String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        return performRequest("GET", requestSpecification, endpoint);
    }

    public Response get(String endpoint, String token) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer " + token);
        return performRequest("GET", requestSpecification, endpoint);
    }

    public Response put(Map<String, String> requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        return performRequest("PUT", requestSpecification, endpoint);
    }

    public Response delete(Map<String, String> requestBody, String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        return performRequest("DELETE", requestSpecification, endpoint);
    }

    public Response delete(String endpoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        return performRequest("DELETE", requestSpecification, endpoint);
    }

    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endpoint) {
        return new RestClient().performRequest(requestType, requestSpecification, endpoint);
    }
}
