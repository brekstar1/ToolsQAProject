package tests.be;

import modelObject.ResponseCreateUser;
import modelObject.ResponseToken;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import services.AccountService;

import java.util.HashMap;
import java.util.Map;

public class CreateUserBETest {

    @Test
    public void testMethod() {
        String userName = "AndreiTest" + System.currentTimeMillis();
        String password = "Calul@65Aremere11!";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userName", userName);
        requestBody.put("password", password);

        AccountService accountService = new AccountService();
        ResponseCreateUser responseCreateUser = accountService.createAccount(requestBody);
        String userID = responseCreateUser.getUserID();
        System.out.println("userId: " + userID);
        ResponseToken responseToken = accountService.generateToken(requestBody);
        String token = responseToken.getToken();
        System.out.println("token: " + token);

        accountService.getSpecificAccount(userID, token);
    }
}
