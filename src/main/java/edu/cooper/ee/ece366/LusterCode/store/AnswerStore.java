package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public interface AnswerStore {

    String addAnswer(Post post, Answer ans);

    List<Answer> getAnswers(Post post);
}
