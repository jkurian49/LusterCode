package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Post;
import org.jdbi.v3.core.Jdbi;

public class PostStoreJdbi implements PostStore{

    private final Jdbi jdbi;
    public PostStoreJdbi(Jdbi jdbi) { this.jdbi = jdbi; }

    public void populateDb() {
        jdbi.useHandle(
                handle ->{
                    handle.execute("CREATE TABLE IF NOT EXISTS posts (id bigint auto_increment, username varchar(255), postType varchar(255), content varchar(255), tags varchar(255), likes int, timestamp datetime, primary key(id));");
                }
        );
    }

    @Override
    public Post createPost(Post post){
        Long id = jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("INSERT INTO post (username, postType, content, tags, likes, timestamp) VALUES (:username, :postType, :content, :tags, :likes, :timestamp)")
                                .bind("username", post.getUsername())
                                .bind("postType", post.getPostType())
                                .bind()
        )
    }
}

/*

    @Override
    public Answer addAnswer(Answer answer) {
        Long id = jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("INSERT INTO answers (username, askPostID, answerType, content, timestamp) VALUES (:username, :askPostID, :answerType, :content, :timestamp)")
                                .bind("username", answer.getUsername())
                                .bind("askPostID", answer.getAskPostID())
                                .bind("answerType", answer.getAnswerType())
                                .bind("content", answer.getContent())
                                .bind("timestamp", answer.getTimestamp())
                                .executeAndReturnGeneratedKeys("id")
                                .mapTo(Long.class)
                                .one());

        answer.setID(id);
        return answer;


    }
    @Override
    public Answer getAnswer(final Long answerID) {
        return jdbi.withHandle(
                handler ->
                        handler
                                .createQuery("SELECT id, username, askPostID, answerType, content, timestamp FROM answers WHERE id = :id")
                                .bind("id", answerID)
                                .mapToBean(Answer.class)
                                .one());
    }
    @Override
    public List<Answer> getAnswers(final Long askPostID) {
        return jdbi.withHandle(
                handler ->
                        handler
                                .createQuery("SELECT id, username, askPostID, answerType, content, timestamp FROM answers WHERE askPostID = :askPostID")
                                .bind("askPostID", askPostID)
                                .mapToBean(Answer.class)
                                .list());
    }


    @Override
    public Integer deleteAnswer(final Long answerID) {
        return jdbi.withHandle(
                handler ->
                        handler
                                .createQuery("DELETE FROM answers WHERE id = :id")
                                .bind("id", answerID)
                                .mapToBean(Integer.class)
                                .one());

    }
}
}

*/