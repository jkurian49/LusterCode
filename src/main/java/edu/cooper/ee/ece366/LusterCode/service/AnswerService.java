package edu.cooper.ee.ece366.LusterCode.service;
import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.store.AnswerStore;


public class AnswerService {

    private final AnswerStore answerStore;

    public AnswerService(AnswerStore answerStore) {
        this.answerStore = answerStore;
    }

    public Answer createAnswer(final Answer answer){
        return answerStore.addAnswer(answer);
    }
}
