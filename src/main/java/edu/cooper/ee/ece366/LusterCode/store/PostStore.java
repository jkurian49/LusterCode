package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Post;
import java.util.List;

public interface PostStore {

    Post createPost(Post post);

    List<Post> getUserPosts(String username);

    Post returnPost(Long postID);

//    Post editPost(Long postID, Post post);

//    String likePost(Long postID);

    Integer deletePost(Long postID);
}
