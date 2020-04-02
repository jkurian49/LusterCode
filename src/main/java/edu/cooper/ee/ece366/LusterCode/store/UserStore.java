package edu.cooper.ee.ece366.LusterCode.store;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;
import spark.ResponseTransformer;

public interface UserStore {

    void newUser(Post post);

    void removeUser(String name, String oldPass, String newPass);

    void modifyPassword(Post post, String tag);

    boolean isUser(Post post, String text);

    User returnUser(String name);
}
