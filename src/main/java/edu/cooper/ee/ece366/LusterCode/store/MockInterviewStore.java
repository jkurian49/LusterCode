package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.MockInterview;

public interface MockInterviewStore {

    MockInterview addMockInterview(MockInterview mockInterview);
    MockInterview getMockInterview(Long mockintID);

}
