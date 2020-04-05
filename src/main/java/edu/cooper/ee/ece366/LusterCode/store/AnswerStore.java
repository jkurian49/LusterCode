package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;

public interface AnswerStore {

    Answer addAnswer(Answer answer);

    Answer getAnswer(Long id);

    Answer deleteAnswer(Long id);

    //List<Answer> getAnswers(Post post);
}
