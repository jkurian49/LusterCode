package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;

import java.util.List;

public interface CookieJar {
    Long addCookie(String username, String cookie);

    String getCookie(String username);
}