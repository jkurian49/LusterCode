package edu.cooper.ee.ece366.LusterCode.service;
import edu.cooper.ee.ece366.LusterCode.model.User;
package edu.cooper.ee.ece366.LusterCode.store;


public class UserService {

    private final UserStore userStore;

    public Service(UserStore userStore) {
        this.userStore = userStore;
    }

    public User createUser(String name, String pass, String firstName, String lastName, String email) {
        userStore.newUser(String name, String pass, String firstName, String lastName, String email);
        return userStore.returnUser(name);
    }

    public User removeUser(String name, String pass) {
        User deletedUser = userStore.returnUser(name);
        userStore.removeUser(String name, String pass);
        return deletedUser;
    }

    public String changePassword(User user, String oldPass, String newPass) {
        User myUser = userStore.returnUser(name);
        modifyPassword(myUser, newPass);
        return newPass;
    }

    public isUser(string name) {
        boolean answer = userStore.isUser(name);
        return answer;
    }

}