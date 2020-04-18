package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import java.util.List;

public interface AnswerStore {

    Answer addAnswer(Answer answer);

    Answer getAnswer(Long id);

    Integer deleteAnswer(Long id);

    List<Answer> getAnswers(Long askPostID);
}
