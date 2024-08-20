package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Post;
import model.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ApiService {

    public static Response postUser() throws IOException {
        String body = Files.readString(Paths.get("/Users/alexisvillamayor/Solvd/ApiAutomationTestNG/src/test/resources/postUser.json"));
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Auth.getTokenFromPropertiesFile())
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPostNewUser)
                .post().then().extract();

        //printing response
        response.getBody().prettyPrint();

        LocalData.getInstance().setUserResponse(new Gson().fromJson(response.asPrettyString(), User.class));
        return response;
    }

    public static Response postNewPost() throws IOException {
        String body = Files.readString(Paths.get("/Users/alexisvillamayor/Solvd/ApiAutomationTestNG/src/test/resources/postNewPost.json"));
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Auth.getTokenFromPropertiesFile())
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPostNewPost)
                .post().then().extract();

        //printing response
        response.getBody().prettyPrint();

        LocalData.getInstance().setPostResponse(new Gson().fromJson(response.asPrettyString(), Post.class));
        return response;
    }

    public static Response getAllUsers() {
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .get(Constants.baseUrl + Constants.endpointGetUser)
                .then().extract();
        //saving response as a JSON
        String jsonResponse = response.getBody().asString();

        // Convert JSONs' list to Java objects
        Type listType = new TypeToken<List<User>>() {
        }.getType();
        List<User> users = new Gson().fromJson(jsonResponse, listType);
        for (User user : users) {
            System.out.println(user);
        }
        LocalData.getInstance().setUserResponses(users);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response getAllPosts() {
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .get(Constants.baseUrl + Constants.endpointGetPost)
                .then().extract();
        //saving response as a JSON
        String jsonResponse = response.getBody().asString();

        // Convert JSONs' list to Java objects
        Type listType = new TypeToken<List<Post>>() {
        }.getType();
        List<Post> posts = new Gson().fromJson(jsonResponse, listType);
        for (Post post : posts) {
            System.out.println(post);
        }
        LocalData.getInstance().setPostResponses(posts);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response putUser() throws IOException {
        String body = Files.readString(Paths.get("/Users/alexisvillamayor/Solvd/ApiAutomationTestNG/src/test/resources/putUser.json"));

        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPutUser)
                .put().then().extract();

//        LocalData.localData.setUserResponse(new Gson().fromJson(response.asPrettyString(), User.class));
        response.getBody().prettyPrint();
        return response;
    }

    public static Response putPost() throws IOException {
        String body = Files.readString(Paths.get("/Users/alexisvillamayor/Solvd/ApiAutomationTestNG/src/test/resources/putPost.json"));

        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPutPost)
                .put().then().extract();

//        LocalData.localData.setUserResponse(new Gson().fromJson(response.asPrettyString(), User.class));
        response.getBody().prettyPrint();
        return response;
    }

    public static Response deleteUser(String userId) throws IOException {
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Auth.getTokenFromPropertiesFile())
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointDeleteUser)
                .delete(userId).then().extract();

//        LocalData.localData.setUserResponse(new Gson().fromJson(response.asPrettyString(), User.class));
        response.getBody().prettyPrint();
        return response;
    }

    public static Response deletePost(String postId) throws IOException {
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + Auth.getTokenFromPropertiesFile())
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointDeletePost)
                .delete(postId).then().extract();

//        LocalData.localData.setUserResponse(new Gson().fromJson(response.asPrettyString(), User.class));
        response.getBody().prettyPrint();
        return response;
    }
}
