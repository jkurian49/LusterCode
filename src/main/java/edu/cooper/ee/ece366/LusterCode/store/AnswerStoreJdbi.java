package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.handler.AnswerHandler;
import edu.cooper.ee.ece366.LusterCode.model.Answer;
import java.util.List;
import org.jdbi.v3.core.Jdbi;

public class AnswerStoreJdbi implements AnswerStore{

    private final Jdbi jdbi;
    public AnswerStoreJdbi(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void populateDb() {
        jdbi.useHandle(
                handle ->{
                        handle.execute("CREATE TABLE IF NOT EXISTS answers (id bigint auto_increment, username varchar(255), askPostID bigint, answerType varchar(255), content varchar(255), primary key(id));");
                });
    }
    @Override
    public Answer addAnswer(final Answer answer) {
        return jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("INSERT INTO answers (username, askPostID, answerType, content) VALUES (:username, :askPostID, :answerType, :content)")
                                .bind("username", answer.getUsername())
                                .bind("askPostID", answer.getAskPostID())
                                .bind("answerType", answer.getAnswerType())
                                .bind("content", answer.getContent())
                                .executeAndReturnGeneratedKeys("id")
                                .mapToBean(Answer.class)
                                .one());
    }
}