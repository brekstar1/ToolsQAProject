package tests.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import services.AccountService;

import java.util.HashMap;
import java.util.Map;

public class CreateUserTest {

    @Test
    public void testMethod(){
        String userName = "AndreiTest" + System.currentTimeMillis();
        String password = "Calul@65Aremere11!";
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("userName", userName);
        requestBody.put("password", password);

        AccountService accountService = new AccountService();
        accountService.createAccount(requestBody);

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();

        WebElement userNameElement = driver.findElement(By.id("userName"));
        userNameElement.sendKeys(userName);
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);
        WebElement loginButtonElement = driver.findElement(By.id("login"));
        loginButtonElement.click();

    }

}
