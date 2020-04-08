package edu.cooper.ee.ece366.LusterCode.handler;

import org.jdbi.v3.core.result.ResultIterator;
import spark.Request;
import spark.Response;
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

    public Answer createAnswer(final Request req, final Response res) {
        Answer answer = gson.fromJson(req.body(), Answer.class);
        return answerService.createAnswer(answer);
    }

    public Answer getAnswer(final Request req, final Response res) {
        Long answerID = Long.valueOf(req.params(":answerID"));
        return answerService.getAnswer(answerID);
    }

    public List<Answer> getAnswers (final Request req, final Response res) {
        Long askPostID = Long.valueOf(req.params(":askPostID"));
        return answerService.getAnswers(askPostID);
    }

    public String deleteAnswer(final Request req, final Response res) {
        Long answerID = Long.valueOf(req.params(":answerID"));
        return answerService.deleteAnswer(answerID);
    }


}
