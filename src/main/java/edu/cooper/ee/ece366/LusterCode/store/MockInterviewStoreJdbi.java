//package edu.cooper.ee.ece366.LusterCode.store;
//
//import edu.cooper.ee.ece366.LusterCode.model.MockInterview;
//import org.jdbi.v3.core.Jdbi;
//
//public class MockInterviewStoreJdbi {
//
//    private final Jdbi jdbi;
//    public MockInterviewStoreJdbi(Jdbi jdbi) {
//        this.jdbi = jdbi;
//    }
//
//    public void populateDb() {
//        jdbi.useHandle(
//                handle ->{
//                    handle.execute("CREATE TABLE IF NOT EXISTS mockinterviews (id bigint auto_increment, name varchar(255), askPostID bigint, answerType varchar(255), content mediumtext, timestamp datetime, primary key(id));");
//                });
//    }
//    @Override
//    public MockInterview addAnswer(MockInterview answer) {
//        Long id = jdbi.withHandle(
//                handle ->
//                        handle
//                                .createUpdate("INSERT INTO answers (username, askPostID, answerType, content, timestamp) VALUES (:username, :askPostID, :answerType, :content, :timestamp)")
//                                .bind("username", answer.getUsername())
//                                .bind("askPostID", answer.getAskPostID())
//                                .bind("answerType", answer.getAnswerType())
//                                .bind("content", answer.getContent())
//                                .bind("timestamp", answer.getTimestamp())
//                                .executeAndReturnGeneratedKeys("id")
//                                .mapTo(Long.class)
//                                .one());
//        answer.setID(id);
//        return answer;
//    }
//
//}
