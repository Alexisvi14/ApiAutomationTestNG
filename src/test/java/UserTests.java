import io.restassured.response.Response;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiService;
import utils.LocalData;

import java.io.IOException;

public class UserTests {
    @Test
    public void postNewUser() throws IOException {
        Response response = ApiService.postUser();
        Assert.assertEquals(response.statusCode(),201, "The status code was not the expected one");
        Assert.assertEquals(LocalData.localData.getUserResponse().getId(),7321846, "Incorrect ID");
        Assert.assertEquals(LocalData.localData.getUserResponse().getStatus(), "active", "User status is wrong");
    }

    @Test
    public void getUserByStatus(){
        Response response = ApiService.getAllUsers();
        Assert.assertEquals(response.statusCode(),200, "The status code was not the expected one");
    }

    @Test
    public void putUser() throws IOException {
        Response response = ApiService.putUser();
        Assert.assertEquals(response.statusCode(),200, "The status code was not the expected one");
    }

    @Test
    public void deleteUser() throws IOException {
        Response response = ApiService.deleteUser("7321846");
        Assert.assertFalse(response.asPrettyString().contains("Resource not found"));
    }
}
