package edu.cooper.ee.ece366.LusterCode.model;

import com.google.gson.annotations.Expose;
import edu.cooper.ee.ece366.LusterCode.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    // Instance Variables
    @Expose private Long id;
    @Expose private String username;
    @Expose private String password;
    @Expose private String firstName;
    @Expose private String lastName;
    @Expose private String email;

    // Constructor Declaration of Class
    public User(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String username, String password, String firstName, String lastName, String email) {
        this.id = -1L;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
        this.id = -1L;
        this.username = null;
        this.password = null;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
    }

    public Long getID() {return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    public void setID(Long id) {this.id = id; }
    public void setUsername(String username) {this.username = username; }
    public void setPassword(String password) {this.password = password; }
    public void setFirstName(String firstName) {this.firstName = firstName; }
    public void setLastName(String lastName) {this.lastName = lastName; }
    public void setEmail(String email) {this.email = email; }

//    public String getName() { return userName; }
//    public void addPost(Long post) { postList.add(post); }
//    public void removePost(Long post) { postList.remove(post); }
//    public ArrayList<Long> returnPost(Long post) { return postList; }

}