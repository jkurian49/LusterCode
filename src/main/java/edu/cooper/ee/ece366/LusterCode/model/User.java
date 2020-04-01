package edu.cooper.ee.ece366.LusterCode.model;

import edu.cooper.ee.ece366.LusterCode.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    // Instance Variables
    public String userName;
    public String pass;
    public String firstName;
    public String lastName;
    public String email;
    public ArrayList<Long> postList;

    // Constructor Declaration of Class
    public User(String userName, String pass, String firstName, String lastName, String email) {
        this.userName = userName;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getName() { return userName; }
    public void addPost(Long post) { postList.add(post); }
    public void removePost(Long post) { postList.remove(post); }
    public ArrayList<Long> returnPost(Long post) { return postList; }

}