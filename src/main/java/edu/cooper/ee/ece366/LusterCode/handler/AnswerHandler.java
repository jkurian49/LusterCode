package edu.cooper.ee.ece366.LusterCode.handler;

import spark.Request;
import com.google.gson.Gson;
import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.service.AnswerService;
import java.util.List;

public class AnswerHandler {

    private final AnswerService answerService;
    private final Gson gson;

    public AnswerHandler(AnswerService answerService, Gson gson) {
        this.answerService = answerService;
        this.gson = gson;
    }

    public Answer createAnswer(final Request req) {
        CreateAnswerRequest createAnswerRequest = gson.fromJson(req.body(), CreateAnswerRequest.class);
        return answerService.createAnswer(createAnswerRequest);
        //Answer answer = gson.fromJson(req.body(), Answer.class);
        //return answerService.createAnswer(answer);
    }

    public class CreateAnswerRequest {
        private final String username;
        private final long askPostID;
        private final String answerType;
        private final String content;

        public CreateAnswerRequest(String username, Long askPostID, String answerType, String content) {
            this.username = username;
            this.askPostID = askPostID;
            this.answerType = answerType;
            this.content = content;
        }

        public String getUsername() { return username; }
        public Long getAskPostID() { return askPostID; }
        public String getAnswerType() { return answerType; }
        public String getContent() { return content; }
    }
}
