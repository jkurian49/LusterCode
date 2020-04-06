package edu.cooper.ee.ece366.LusterCode.model;

import com.google.gson.annotations.Expose;

public class Answer {
    // Instance Variables
    @Expose private final Long id;
    @Expose private final String username;
    @Expose private final Long askPostID;
    @Expose private final String answerType; // with code or post reply
    @Expose private final String content; // either a file path to code or a reply text
    //private final Timestamp timestamp;

    public Answer(Long id, String username, Long askPostID, String answerType, String content){
        this.id = id;
        this.username = username;
        this.askPostID = askPostID;
        this.answerType = answerType;
        this.content = content;
    }

    public Long getID() { return id; }
    public String getUsername() { return username; }
    public Long getAskPostID() { return askPostID; }
    public String getAnswerType() { return answerType; }
    public String getContent() { return content; }
    //public Timestamp getTime() { return timestamp; }

}