package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PostStoreImpl implements PostStore {

    private Map<Long, Post> postList;

    public PostStoreImpl() {
        this.postList = new HashMap<>();
    }
    public PostStoreImpl(Map<Long, Post> postList) {this.postList = postList;}
    public PostStoreImpl(Post post) {
        postList.put(post.getId(), post);
    }

    public void newPost(Post post){
        postList.put(post.getId(), post);
    }

    @Override
    public Post getPost(Long id) {
        return postList.get(id);
    }

    @Override
    public void addLike(Post post, User user){
        throw new UnsupportedOperationException("Error: addLike not implemented yet\n");
    }

    @Override
    public void addTag(Post post, String newtag){
        String[] tags = post.getTags();
        tags = Arrays.copyOf(tags, tags.length +1);
        tags[tags.length-1] = newtag;

        post.setTags(tags);
    }

    @Override
    public void editPost(Post post, String text){
        throw new UnsupportedOperationException("Error: editPost not implemented yet\n");
    }

}

