package edu.cooper.ee.ece366.LusterCode.service;
import edu.cooper.ee.ece366.LusterCode.model.User;
import edu.cooper.ee.ece366.LusterCode.store.CookieJar;
import edu.cooper.ee.ece366.LusterCode.store.UserStore;
import spark.Request;
import com.google.gson.Gson;
import spark.Response;
import org.mindrot.jbcrypt.*;

import java.math.BigInteger;
import java.security.MessageDigest;

public class UserService {

    private final UserStore userStore;
    private final CookieJar cookieJar;


    public UserService(UserStore userStore, CookieJar cookieJar) {
        this.userStore = userStore;
        this.cookieJar = cookieJar;
    }



    public User createUser(final User user){
        String salt = BCrypt.gensalt();
        System.out.print(salt);
        user.password = BCrypt.hashpw(user.password, salt);
        return userStore.addUser(user);
    }

    public User getUser(final String username) {
        return userStore.getUser(username);
    }

    public String login(final String username, final String password, Request request, Response response) {
        if (BCrypt.checkpw(password, userStore.getUser(username).getPassword())) { //Login Success

            String cookieval = "";  // empty string to become cookie value

            try {   // implements hashing alg to obtain string for cookie
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                digest.reset();
                digest.update(username.getBytes("utf8"));
                cookieval = String.format("%040x", new BigInteger(1, digest.digest()));
            } catch (Exception e){
                e.printStackTrace();
            }
            response.cookie("identifier", cookieval); //Set cookie for future requests

            cookieJar.addCookie(username, cookieval);

            System.out.print(new StringBuilder().append("login successful with new cookie: ").append(cookieval).toString());

            return "success";

        } else { //Login Fail
            System.out.print("login failed\n");
            response.header("login", "fail");
            return "failure";
        }

    }

    public String deleteUser(final String username) {

        Integer deletion = userStore.deleteUser(username);
        if (deletion == 1) {return "DELETION SUCCESSFUL"; }
        else {return "ERROR DELETING FROM DATABASE"; }
    }



//    public static User createUser(String name, String pass, String firstName, String lastName, String email) {
//        userStore.newUser(name, pass, firstName, lastName, email);
//        return userStore.returnUser(name);
//    }
//
//    public User removeUser(String name, String pass) {
//        User deletedUser = userStore.returnUser(name);
//        userStore.removeUser(name);
//        return deletedUser;
//    }
//
//    public String changePassword(String name, String oldPass, String newPass) {
//        User myUser = userStore.returnUser(name);
//        userStore.modifyPassword(name, newPass);
//        return newPass;
//    }
//
//    public boolean isUser(String name) {
//        boolean answer = userStore.isUser(name);
//        return answer;
//    }

}

