package edu.cooper.ee.ece366.LusterCode.handler;
import edu.cooper.ee.ece366.LusterCode.service;
import edu.cooper.ee.ece366.LusterCode.model.User;
import edu.cooper.ee.ece366.LusterCode.store;

public class UserHandler {
// ###################### Creating/removing/modifying USERS ###################### //
    private final Service service;
    private final Gson gson;

    public UserHandler(Service service, Gson gson) {
        this.service = service;
        this.gson = gson;
    }

    //Handler for user creation
    public String userMake(Request req) {
        String name = req.params(":field1");
        String pass = req.params(":field2");
        String firstName = req.params(":field2");
        String lastName = req.params(":field1");
        String email = req.params(":field2");

        return service.createUser(name, pass, firstName, lastName, email)
    }

    //Handler for user deletion
    public String userRemover(Request req) {
        String pass = req.params(":field2");
        String name = req.params(":field1");

        return service.removeUser(name, pass);
    }

    //Handler for password modification
    public String passChange(Request req) {
        String oldPass = req.params(":field2");
        String newPass = req.params(":field3");
        String name = req.params(":field1");

        return service.changePassword(name, oldPass, newPass);
    }

    //Check if user in database
    public boolean isUser(String name) {
        return service.isUser(name);
    }
}