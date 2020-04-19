package edu.cooper.ee.ece366.LusterCode.handler;

import edu.cooper.ee.ece366.LusterCode.model.User;
import edu.cooper.ee.ece366.LusterCode.service.UserService;
import spark.Request;
import com.google.gson.Gson;

public class UserHandler {
// ###################### Creating/removing/modifying USERS ###################### //
    private final UserService userService;


    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    //Handler for user creation
    public User userMake(Request req) {
        String name = req.params(":username");
        String pass = req.params(":password");
        String firstName = req.params(":first");
        String lastName = req.params(":last");
        String email = req.params(":email");

        return userService.createUser(name, pass, firstName, lastName, email);
    }

    //Handler for user deletion
    public User userRemover(Request req) {
        String name = req.params(":username");
        String pass = req.params(":password");

        return userService.removeUser(name, pass);
    }

    //Handler for password modification
    public String passChange(Request req) {
        String oldPass = req.params(":password");
        String newPass = req.params(":newpassword");
        String name = req.params(":username");

        return userService.changePassword(name, oldPass, newPass);
    }

    //Check if user in database
    public boolean isUser(Request req) {
        String name = req.params(":username");
        return userService.isUser(name);
    }

}