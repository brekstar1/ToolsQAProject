package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    public Response performRequest(String requestType, RequestSpecification requestSpecification, String endpoint) {
        switch (requestType) {
            case "POST":
                return prepareClient(requestSpecification).post(endpoint);
            case "PUT":
                return prepareClient(requestSpecification).put(endpoint);
            case "GET":
                return prepareClient(requestSpecification).get(endpoint);
            case "DELETE":
                return prepareClient(requestSpecification).delete(endpoint);
        }
        return null;
    }

    public RequestSpecification prepareClient(RequestSpecification requestSpecification) {
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification;
    }
}
