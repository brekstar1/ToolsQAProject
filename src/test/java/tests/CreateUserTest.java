package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CreateUserTest {

    @Test
    public void testMethod(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.contentType(ContentType.JSON);

        String userName = "AndreiTest" + System.currentTimeMillis();
        String password = "Calul@65Aremere11!";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userName", userName);
        requestBody.put("password", password);

        requestSpecification.body(requestBody);

        Response response = requestSpecification.post("/Account/v1/User");
        System.out.println(response.statusLine());
        response.getBody().prettyPrint();

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();

        WebElement userNameElement = driver.findElement(By.id("userName"));
        userNameElement.sendKeys(userName);
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
        WebElement logginButtonElement = driver.findElement(By.id("login"));
        logginButtonElement.click();

    }

}
