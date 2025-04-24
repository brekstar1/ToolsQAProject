package tests.be;

import org.testng.annotations.Test;
import services.BookStoreService;

public class ObtainAllBooksTest {

    @Test
    public void testMethod(){
        BookStoreService bookStoreService = new BookStoreService();
        bookStoreService.getAllBooks();
    }
}
