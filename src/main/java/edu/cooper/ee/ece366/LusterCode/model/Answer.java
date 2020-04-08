package edu.cooper.ee.ece366.LusterCode.model;

import com.google.gson.annotations.Expose;
import java.time.LocalDateTime;

public class Answer {
    // Instance Variables
    @Expose private Long id;
    @Expose private String username;
    @Expose private Long askPostID;
    @Expose private String answerType; // with code or post reply
    @Expose private String content; // either a file path to code or a reply text
    @Expose private LocalDateTime timestamp;

    public Answer(Long id, String username, Long askPostID, String answerType, String content, LocalDateTime timestamp){
        this.id = id;
        this.username = username;
        this.askPostID = askPostID;
        this.answerType = answerType;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Answer(String username, Long askPostID, String answerType, String content, LocalDateTime timestamp){
        this.id = -1L;
        this.username = username;
        this.askPostID = askPostID;
        this.answerType = answerType;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Answer(){
        this.id = -1L;
        this.username = null;
        this.askPostID = -1L;
        this.answerType = null;
        this.content = null;
        this.timestamp = LocalDateTime.now();
    }

    public Long getID() { return id; }
    public String getUsername() { return username; }
    public Long getAskPostID() { return askPostID; }
    public String getAnswerType() { return answerType; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() {return timestamp; }

    public void setID(Long id) {this.id = id; }
    public void setUsername(String username) {this.username = username; }
    public void setAskPostID(Long askPostID) { this.askPostID = askPostID; }
    public void setAnswerType(String answerType) {this.answerType = answerType; }
    public void setContent(String content) {this.content = content; }
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp; }

}