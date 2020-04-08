package edu.cooper.ee.ece366.LusterCode.model;

import com.google.gson.annotations.Expose;


import java.util.List;

public class MockInterview {

    @Expose private Long id;
    @Expose private String name;
    @Expose private List<Long> askPostIDs;
    @Expose private String difficulty;
    @Expose private List<Long> answerIDs;

    public MockInterview(Long id, String name, List<Long> askPostIDs, String difficulty, List<Long> answerIDs){
        this.id = id;
        this.name = name;
        this.askPostIDs = askPostIDs;
        this.difficulty = difficulty;
        this.answerIDs = answerIDs;
    }

    public MockInterview(String name, List<Long> askPostIDs, String difficulty, List<Long> answerIDs){
        this.id = -1L;
        this.name = name;
        this.askPostIDs = askPostIDs;
        this.difficulty = difficulty;
        this.answerIDs = answerIDs;
    }
    public MockInterview() {
        this.id = -1L;
        this.name = null;
        this.askPostIDs = null;
        this.difficulty = null;
        this.answerIDs = null;
    }

    public Long getID() {return id; }
    public String getName() { return name; }
    public List<Long> getAskPostIDs() { return askPostIDs; }
    public String getDifficulty() {return difficulty; }
    public List<Long> getAnswerIDs() {return answerIDs; }

    public void setID(Long id) {this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAskPostIDs(List<Long> askPostIDs) { this.askPostIDs = askPostIDs; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setAnswerIDs(List<Long> answerIDs) { this.answerIDs = answerIDs; }
}
