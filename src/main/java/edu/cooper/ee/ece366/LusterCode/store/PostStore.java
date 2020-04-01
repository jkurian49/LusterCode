package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;
import spark.ResponseTransformer;

public interface PostStore {

    Post getPost(Long id);

    void newPost(Post post);

    void addLike(Post post, User user);

    void addTag(Post post, String tag);

    void editPost(Post post, String text);
}
