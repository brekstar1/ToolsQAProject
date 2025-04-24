package services;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class AccountService extends CommonService {

    public void createAccount(Map<String, String> requestBody) {
        Response response = post(requestBody,"/Account/v1/User");
        Assert.assertEquals(response.getStatusCode(),201);
        response.getBody().prettyPrint();
    }

    public void generateToken(Map<String, String> requestBody){
        Response response = post(requestBody,"/Account/v1/GenerateToken");
        Assert.assertEquals(response.getStatusCode(),200);
        response.getBody().prettyPrint();
    }
}
