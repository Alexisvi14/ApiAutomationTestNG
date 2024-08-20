import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiService;
import utils.LocalData;

import java.io.IOException;

public class PostTests {
    @Test
    public void postNewUser() throws IOException {
        Response response = ApiService.postNewPost();
        Assert.assertEquals(response.statusCode(), 201, "The status code was not the expected one");
        Assert.assertEquals(LocalData.getInstance().getPostResponse().getId(), 149130, "Incorrect ID");
        Assert.assertEquals(LocalData.getInstance().getPostResponse().getTitle(), "The title.", "Post title is wrong");
    }

    @Test
    public void getPostById() {
        Response response = ApiService.getAllPosts();
        Assert.assertEquals(response.statusCode(), 200, "The status code was not the expected one");
    }

    @Test
    public void putPost() throws IOException {
        Response response = ApiService.putPost();
        Assert.assertEquals(response.statusCode(), 200, "The status code was not the expected one");
    }

    @Test
    public void deletePostById() throws IOException {
        Response response = ApiService.deletePost("149130");
        Assert.assertFalse(response.asPrettyString().contains("Resource not found"));
    }
}
