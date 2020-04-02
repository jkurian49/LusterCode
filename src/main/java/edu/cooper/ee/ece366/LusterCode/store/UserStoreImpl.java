package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class UserStoreImpl implements UserStore {

    private final Map<String, User>> UserList;

    public UserStoreImpl() {
        this.UserList = new HashMap<>();
    }

    public UserStoreImpl(Map<String, User> UserList) {
        this.UserList = UserList;
    }

    @Override
    public void newUser(User user) {
        User newU = new User(name, pass, firstName, lastName, email);
        UserList.put(name, newU);
    }

    @Override
    public void removeUser(User user, Item item) {
        UserList.remove(name);
    }

    @Override
    public void modifyPassword(User user, String password) {
        UserList.get(name).pass = password;
    }

    @Override
    public boolean isUser(String name) {
        return userList.containsKey(name);
    }

    public boolean returnUser(User user) {
        return userList.get(name);
    }
}