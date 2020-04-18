package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Post;

public interface PostStore {

    Post createPost(Post post);

    Post editPost(Long postID, Post post);

    Post returnPost(Long postID);

    String likePost(Long postID);

    String deletePost(Long postID);
}
