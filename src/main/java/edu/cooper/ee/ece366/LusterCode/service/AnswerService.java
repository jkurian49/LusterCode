package edu.cooper.ee.ece366.LusterCode.service;
import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.store.AnswerStore;

import java.util.List;


public class AnswerService {

    private final AnswerStore answerStore;

    public AnswerService(AnswerStore answerStore) {
        this.answerStore = answerStore;
    }

    public Answer createAnswer(final Answer answer){
        return answerStore.addAnswer(answer);
    }

    public Answer getAnswer(final Long id) {
        return answerStore.getAnswer(id);
    }

    public List<Answer> getAnswers(final Long askPostID) {return answerStore.getAnswers(askPostID);}

    public String deleteAnswer(final Long id) {

        Integer deletion = answerStore.deleteAnswer(id);
        if (deletion == 1) {return "DELETION SUCCESSFUL"; }
        else {return "ERROR DELETING FROM DATABASE"; }
    }
}
