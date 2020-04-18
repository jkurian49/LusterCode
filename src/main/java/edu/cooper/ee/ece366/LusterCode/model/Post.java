package edu.cooper.ee.ece366.LusterCode.model;

import com.google.gson.annotations.Expose;
import java.time.LocalDateTime;

public class Post {

    // Instance Variables
    @Expose private Long id;
    @Expose private String username;
    @Expose private String postType;
    @Expose private String content;
    @Expose private String tags;
    @Expose private Integer likes; // eventually this will include list of users (like might be its own class)
    @Expose private LocalDateTime timestamp;

    //for retrieving object from database
    public Post(Long id, String username, String postType, String content,
                  String tags, Integer likes, LocalDateTime timestamp){
        this.id = -1L;
        this.username = username;
        this.postType = postType;
        this.content = content;
        this.tags = tags;
        this.likes = likes;
        this.timestamp = timestamp;
    }

    //for creating object to be stored in database, which creates its own ID
    public Post(String username, String postType, String content,
                String tags, Integer likes, LocalDateTime timestamp){
        this.id = id;
        this.username = username;
        this.postType = postType;
        this.content = content;
        this.tags = tags;
        this.likes = likes;
        this.timestamp = timestamp;
    }

    //blank post, just because
    public Post(){
        this.id = -1L;
        this.username = null;
        this.postType = null;
        this.content = null;
        this.tags = null;
        this.likes = 0;
        this.timestamp = LocalDateTime.now();
    }

    public Long getID() { return id; }
    public String getUsername() { return username; }
    public String getPostType() { return postType; }
    public String getContent() { return content; }
    public String getTags() { return tags; }
    public Integer getLikes() { return likes; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setID() { this.id = id; }
    public void setUsername() { this.username = username; }
    public void setPostType() { this.postType = postType; }
    public void setContent() { this.content = content; }
    public void setTags() { this.tags = tags; }
    public void setLikes() { this.likes = likes; }
    public void setTimestamp() { this.timestamp = timestamp; }

}
