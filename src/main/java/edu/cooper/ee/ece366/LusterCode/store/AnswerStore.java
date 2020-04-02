package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;
import edu.cooper.ee.ece366.LusterCode.handler.AnswerHandler.CreateAnswerRequest;
import java.util.List;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public interface AnswerStore {

    //old String addAnswer(Post post, Answer ans);
    Answer addAnswer(CreateAnswerRequest createAnswerRequest);

    //List<Answer> getAnswers(Post post);
}
