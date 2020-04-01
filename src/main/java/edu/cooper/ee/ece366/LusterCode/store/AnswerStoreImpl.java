package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import edu.cooper.ee.ece366.LusterCode.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerStoreImpl implements AnswerStore {

    private final Map<Post, ArrayList<Answer>> answerList;

    public AnswerStoreImpl() {
        this.answerList = new HashMap<>();
    }
    public AnswerStoreImpl(Map<Post, ArrayList<Answer>> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String addAnswer(Post post, Answer ans) {
        String returnString = "";
        ArrayList<Answer> answers = answerList.getOrDefault(post, new ArrayList<>());
        answers.add(ans);
        answerList.put(post,answers);
        returnString = returnString + "SUCCESFFULY ANSWERED POST WITH ID: " + post.getId();
        if (ans.getAnswerType().contains("code")) {
            returnString = returnString + "\nSORRY, OUR BUILT-IN COMPILER IS NOT YET IMPLEMENTED.";
        }
        return returnString;
    }

    @Override
    public List<Answer> getAnswers(Post post) {
        return new ArrayList<>(answerList.get(post));
    }
}

