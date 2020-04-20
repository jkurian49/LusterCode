package edu.cooper.ee.ece366.LusterCode.service;

import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.store.AnswerStore;
import edu.cooper.ee.ece366.LusterCode.store.PostStore;
import java.util.List;

public class PostService {

    private final PostStore postStore;
    public PostService(PostStore postStore) {
        this.postStore = postStore;
    }

    public Post createPost(Post post) { return postStore.createPost(post);}

    public List<Post> getUserPosts(String username) { return postStore.getUserPosts(username); }

//  public Post addTags(Post post) { }

/*    public Post editPost(Long postID, Post post) { return postStore.editPost(postID, post); }

    public Post returnPost(Long postID) { return postStore.returnPost(postID); }

    public String likePost(Long postID) { return postStore.likePost(postID); }

    public String deletePost(Long postID) { return postStore.deletePost(postID); }*/

}
