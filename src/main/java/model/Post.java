package model;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    private long id;
    @SerializedName("user_id")
    private long user_id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public Post(long id, long user_id, String title, String body) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
