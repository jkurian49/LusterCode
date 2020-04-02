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
        jdbi.withHandle(
                handle ->
                        handle.execute(
                                "create table items (answerID bigint auto_increment, username varchar(255), askPostID bigint," +
                                        "answerType varchar(255), content varchar(255));"));
    }

    @Override
    public Item addAnswer(final Handler.CreateAnswerRequest createAnswerRequest) {
        return jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("insert into answer (username, askPostID, answerType, content)..." +
                                        " values (:username, :username, :askPostID, :answerType, :content)")
                                .bind("username", createAnswerRequest.getUsername())
                                .bind("askPostID", createAnswerRequest.getAskPostID())
                                .bind("answerType", createAnswerRequest.getAnswerType())
                                .bind("content", createAnswerRequest.getContent())
                                .executeAndReturnGeneratedKeys("answerID")
                                .mapToBean(Answer.class)
                                .one());
    }
}