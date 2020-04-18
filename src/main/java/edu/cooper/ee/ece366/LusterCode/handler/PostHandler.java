package edu.cooper.ee.ece366.LusterCode.handler;

import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.service.PostService;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;
import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.service.PostService;
import java.util.List;


public class PostHandler {
    private final PostService postService;
    private final Gson gson;

    public PostHandler(PostService postService, Gson gson) {
        this.postService = postService;
        this.gson = gson;
    }

    public Post createPost(final Request req, final Response res) {
        Post post = gson.fromJson(req.body(), Post.class);
        return postService.createPost(post);
    }

/*
    public Post editPost(final Request req, final Response res) {
        Long postID = Long.valueOf(req.params(":postID"));
        Post post = gson.fromJson(req.body(), Post.class);
        return postService.editPost(postID, post);
    }

//    public Post addTags(final Request req, final Response res) {
//        Long postID = Long.valueOf(req.params(":postID"));
//        return postService.addTags(postID);
//    }

    public Post returnPost(final Request req, final Response res) {
        Long postID = Long.valueOf(req.params(":postID"));
        return postService.returnPost(postID);
    }

    public String likePost(final Request req, final Response res) {
        Long postID = Long.valueOf(req.params(":postID"));
        return postService.likePost(postID);
    }

    public String deletePost(final Request req, final Response res) {
        Long postID = Long.valueOf(req.params(":postID"));
        return postService.deletePost(postID);
    }
*/
}
