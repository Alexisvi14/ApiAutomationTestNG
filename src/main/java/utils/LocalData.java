package utils;

import model.Post;
import model.User;

import java.util.List;

public class LocalData {
    private static LocalData instance;
    private User userResponse;
    private List<User> userResponses;

    private Post postResponse;

    private List<Post> postResponses;

    private LocalData() {
    }

    public static LocalData getInstance() {
        if (instance == null) {
            synchronized (LocalData.class) {
                if (instance == null) {
                    instance = new LocalData();
                }
            }
        }
        return instance;
    }

    public User getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(User userResponse) {
        this.userResponse = userResponse;
    }

    public List<User> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<User> userResponses) {
        this.userResponses = userResponses;
    }

    public Post getPostResponse() {
        return postResponse;
    }

    public void setPostResponse(Post postResponse) {
        this.postResponse = postResponse;
    }

    public List<Post> getPostResponses() {
        return postResponses;
    }

    public void setPostResponses(List<Post> postResponses) {
        this.postResponses = postResponses;
    }
}
