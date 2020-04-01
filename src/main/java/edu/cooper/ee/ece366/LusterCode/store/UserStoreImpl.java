package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class UserStoreImpl implements UserStore {

    private final Map<User, Map<Integer, User>> UserList;

    public UserStoreImpl() {
        this.UserList = new HashMap<>();
    }

    public UserStoreImpl(Map<Integer, User> UserList) {
        this.UserList = UserList;
    }

    @Override
    public void newUser(User user) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void removeUser(User user, Item item) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void modifyPassword(User user, Item item, Integer quantity) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public boolean isUser(User user) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}