package edu.cooper.ee.ece366.LusterCode.handler;

import spark.Request;
import spark.Response;
import com.google.gson.Gson;
import edu.cooper.ee.ece366.LusterCode.model.MockInterview;
import edu.cooper.ee.ece366.LusterCode.service.MockInterviewService;
import java.util.List;

public class MockInterviewHandler {

    private final MockInterviewService mockInterviewService;
    private final Gson gson;

    public MockInterviewHandler(MockInterviewService mockInterviewService, Gson gson) {
        this.mockInterviewService = mockInterviewService;
        this.gson = gson;
    }

    public MockInterview createMockInterview(final Request req, final Response res) {
        MockInterview mockInterview = gson.fromJson(req.body(), MockInterview.class);
        return mockInterviewService.createMockInterview(mockInterview);
    }
}
