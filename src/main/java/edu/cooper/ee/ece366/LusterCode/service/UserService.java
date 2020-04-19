package edu.cooper.ee.ece366.LusterCode.service;
import edu.cooper.ee.ece366.LusterCode.model.User;
import edu.cooper.ee.ece366.LusterCode.store.UserStore;;

public class UserService {

    private final UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }

    public User createUser(final User user){
        return userStore.addUser(user);
    }

    public User getUser(final String username) {
        return userStore.getUser(username);
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

