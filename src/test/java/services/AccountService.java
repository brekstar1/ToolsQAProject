package services;

import io.restassured.response.Response;
import modelObject.ResponseCreateUser;
import modelObject.ResponseToken;
import org.testng.Assert;

import javax.sound.midi.Soundbank;
import java.util.Map;

public class AccountService extends CommonService {

    public ResponseCreateUser createAccount(Map<String, String> requestBody) {
        Response response = post(requestBody, "/Account/v1/User");
        Assert.assertEquals(response.getStatusCode(), 201);
        return response.as(ResponseCreateUser.class);
    }

    public ResponseToken generateToken(Map<String, String> requestBody) {
        Response response = post(requestBody, "/Account/v1/GenerateToken");
        Assert.assertEquals(response.getStatusCode(), 200);
        return response.as(ResponseToken.class);
    }

    public void getSpecificAccount(String userID, String token) {
        Response response = get("/Account/v1/User/"+userID,token);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
