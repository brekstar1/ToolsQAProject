package services;

import io.restassured.response.Response;
import org.testng.Assert;

public class BookStoreService extends CommonService{

    public void getAllBooks(){
        Response response = get("/BookStore/v1/Books");
        Assert.assertEquals(response.getStatusCode(),200);
        response.getBody().prettyPrint();
    }

}
