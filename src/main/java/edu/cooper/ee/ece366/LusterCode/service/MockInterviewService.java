package edu.cooper.ee.ece366.LusterCode.service;

import edu.cooper.ee.ece366.LusterCode.model.MockInterview;
import edu.cooper.ee.ece366.LusterCode.store.MockInterviewStore;

public class MockInterviewService {
    private final MockInterviewStore mockInterviewStore;

    public MockInterviewService(MockInterviewStore mockInterviewStore) {
        this.mockInterviewStore = mockInterviewStore;
    }

    public MockInterview createMockInterview(final MockInterview mockInterview){
        return mockInterviewStore.addMockInterview(mockInterview);
    }
}
