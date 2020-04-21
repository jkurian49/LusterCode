package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.MockInterview;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class MockInterviewStoreJdbi implements MockInterviewStore {

    private final Jdbi jdbi;
    public MockInterviewStoreJdbi(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void populateDb() {
        jdbi.useHandle(
                handle ->{
                    handle.execute("CREATE TABLE IF NOT EXISTS mockints (id bigint auto_increment, name varchar(255), difficulty varchar(255), primary key(id));");
                });

        jdbi.useHandle(
                handle ->{
                    handle.execute("CREATE TABLE IF NOT EXISTS mockintjoin (id bigint auto_increment, intID bigint, askPostID bigint, answerID bigint, primary key(id));");
                });
    }
    @Override
    public MockInterview addMockInterview(MockInterview mockInterview) {
        Long id = jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("INSERT INTO mockints (name, difficulty) VALUES (:name, :difficulty)")
                                .bind("name", mockInterview.getName())
                                .bind("difficulty", mockInterview.getDifficulty())
                                .executeAndReturnGeneratedKeys("id")
                                .mapTo(Long.class)
                                .one());

        List<Long> postIDs = mockInterview.getAskPostIDs();
        List<Long> answerIDs = mockInterview.getAnswerIDs();

        for (int i = 0; i < postIDs.size(); i++) {
            Long postID = postIDs.get(i);
            Long answerID = answerIDs.get(i);
            addMockInterviewJoin(id, postID, answerID);
        }
        mockInterview.setID(id);
        return mockInterview;
    }

    private void addMockInterviewJoin(Long intID, Long askPostID, Long answerID) {
        jdbi.useHandle(
                handle ->
                        handle
                                .createUpdate("INSERT INTO mockintjoin (intID, askPostID, answerID) VALUES (:intID, :askPostID, :answerID)")
                                .bind("intID", intID)
                                .bind("askPostID", askPostID)
                                .bind("answerID", answerID)
                                .execute());
    }

    @Override
    public MockInterview getMockInterview(final Long intID) {
        MockInterview mockInterview = jdbi.withHandle(
                handler ->
                        handler
                                .createQuery("SELECT id, name, difficulty FROM mockints WHERE id = :intID")
                                .bind("intID", intID)
                                .mapToBean(MockInterview.class)
                                .one());

        List<Long> askPostIDs = getMockInterviewAskPostIDs(intID);
        mockInterview.setAskPostIDs(askPostIDs);
        List<Long> answerIDs = getMockInterviewAnswerIDs(intID);
        mockInterview.setAnswerIDs(answerIDs);
        return mockInterview;
    }

    private List<Long> getMockInterviewAskPostIDs(Long intID){
        return jdbi.withHandle(
                handler ->
                        handler.
                                createQuery("SELECT askPostID FROM mockintjoin WHERE intID = :intID")
                                .bind("intID", intID)
                                .mapTo(Long.class)
                                .list());
    }

    private List<Long> getMockInterviewAnswerIDs(Long intID){
        return jdbi.withHandle(
                handler ->
                        handler.
                                createQuery("SELECT answerID FROM mockintjoin WHERE intID = :intID")
                                .bind("intID", intID)
                                .mapTo(Long.class)
                                .list());
    }

}


