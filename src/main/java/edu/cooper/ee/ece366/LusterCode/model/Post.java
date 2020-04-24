package edu.cooper.ee.ece366.LusterCode.model;

import com.google.gson.annotations.Expose;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

    // Instance Variables
    @Expose private Long id;
    @Expose private String username;
    @Expose private String postType;
    @Expose private String content;
    @Expose private String tags;
    @Expose private Integer likes; // eventually this will include list of users (like might be its own class)
    @Expose private String timestamp;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //for retrieving object from database
    public Post(Long id, String username, String postType, String content,
                String tags, Integer likes, LocalDateTime timestamp){
        this.id = -1L;
        this.username = username;
        this.postType = postType;
        this.content = content;
        this.tags = tags;
        this.likes = likes;
        this.timestamp = timestamp.format(formatter);
    }

    //for creating object to be stored in database, which creates its own ID
    public Post(String username, String postType, String content,
                String tags, Integer likes){
        this.id = id;
        this.username = username;
        this.postType = postType;
        this.content = content;
        this.tags = tags;
        this.likes = likes;
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    //blank post, just because
    public Post(){
        this.id = -1L;
        this.username = null;
        this.postType = null;
        this.content = null;
        this.tags = null;
        this.likes = 0;
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    public Long getID() { return id; }
    public String getUsername() { return username; }
    public String getPostType() { return postType; }
    public String getContent() { return content; }
    public String getTags() { return tags; }
    public Integer getLikes() { return likes; }
    public String getTimestamp() { return timestamp; }

    public void setID(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPostType(String postType) { this.postType = postType; }
    public void setContent(String content) { this.content = content; }
    public void setTags(String tags) { this.tags = tags; }
    public void setLikes(Integer likes) { this.likes = likes; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

}