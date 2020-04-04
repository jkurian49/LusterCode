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
        Answer answer = gson.fromJson(req.body(), Answer.class);
        return answerService.createAnswer(answer);
    }
}
