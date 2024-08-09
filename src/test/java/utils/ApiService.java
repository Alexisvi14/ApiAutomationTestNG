package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
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
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer " + Auth.getTokenFromPropertiesFile())
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPost)
                .post().then().extract();

        //printing response
        response.getBody().prettyPrint();
        //Set the response into a Pet object in LocalData class
        LocalData.localData.setUserResponse(new Gson().fromJson(response.asPrettyString(), User.class));
        return response;
    }

    public static Response getAllUsers(){
        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type","application/json")
                .get(Constants.baseUrl + Constants.endpointGet)
                .then().extract();
        //saving response as a JSON
        String jsonResponse = response.getBody().asString();

        // Convert JSONs' list to Java objects
        Type listType = new TypeToken<List<User>>(){}.getType();
        List<User> users = new Gson().fromJson(jsonResponse, listType);
        for (User user : users) {
            System.out.println(user);
        }
        LocalData.localData.setUserResponses(users);
        response.getBody().prettyPrint();
        return response;
    }

    public static Response putUser() throws IOException {
        String body = Files.readString(Paths.get("/Users/alexisvillamayor/Solvd/ApiAutomationTestNG/src/test/resources/putUser.json"));

        Response response = (Response) RestAssured.given()
                .log()
                .all()
                .header("Content-Type","application/json")
                .body(body)
                .baseUri(Constants.baseUrl)
                .basePath(Constants.endpointPut)
                .put().then().extract();

//        LocalData.localData.setUserResponse(new Gson().fromJson(response.asPrettyString(), User.class));
        response.getBody().prettyPrint();
        return response;
    }
}
