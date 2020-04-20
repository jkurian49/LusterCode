package edu.cooper.ee.ece366.LusterCode.store;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;
import spark.ResponseTransformer;

public interface UserStore {

    User addUser(User user);

    User getUser(String username);

    Integer deleteUser(String username);

  //  User login(String username);

//    void removeUser(String name);
//
//    void modifyPassword(String name, String password);
//
//    boolean isUser(String name);
//
//    User returnUser(String name);
}
