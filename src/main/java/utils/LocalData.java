package utils;

import model.User;

import java.util.List;

public class LocalData {
    public static LocalData localData = new LocalData();
    private User userResponse;
    private List<User> userResponses;

    public static LocalData getLocalData() {
        return localData;
    }

    public static void setLocalData(LocalData localData) {
        LocalData.localData = localData;
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
}
