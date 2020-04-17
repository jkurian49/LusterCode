package edu.cooper.ee.ece366.LusterCode.store;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;
import spark.ResponseTransformer;

public interface UserStore {

    void newUser(String name, String pass, String firstName, String lastName, String email);

    void removeUser(String name);

    void modifyPassword(String name, String password);

    boolean isUser(String name);

    User returnUser(String name);
}
