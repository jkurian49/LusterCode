package edu.cooper.ee.ece366.LusterCode.store;

//import edu.cooper.ee.ece366.LusterCode.model.Answer;
//import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class UserStoreImpl implements UserStore {

    private final Map<String, User> UserList;

    public UserStoreImpl() {
        this.UserList = new HashMap<>();
    }

    public UserStoreImpl(Map<String, User> UserList) {
        this.UserList = UserList;
    }


    @Override
    public void newUser(String name, String pass, String firstName, String lastName, String email) {
        User newU = new User(name, pass, firstName, lastName, email);
        UserList.put(name, newU);
    }

    @Override
    public void removeUser(String name) {
        UserList.remove(name);
    }

    @Override
    public void modifyPassword(String name, String password) {
        UserList.get(name).pass = password;
    }

    @Override
    public boolean isUser(String name) {
        return UserList.containsKey(name);
    }

    @Override
    public User returnUser(String name) {
        return UserList.get(name);
    }

}