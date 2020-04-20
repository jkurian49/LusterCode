package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Post;
import java.util.List;

public interface PostStore {

    Post createPost(Post post);

    List<Post> getUserPosts(String username);

//    Post editPost(Long postID, Post post);

//    Post returnPost(Long postID);

//    String likePost(Long postID);

//    String deletePost(Long postID);
}
