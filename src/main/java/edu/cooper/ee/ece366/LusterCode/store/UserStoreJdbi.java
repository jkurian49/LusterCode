package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.User;
import org.jdbi.v3.core.Jdbi;

public class UserStoreJdbi implements UserStore{

    private final Jdbi jdbi;

    public UserStoreJdbi(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void populateDb() {
        jdbi.useHandle(
                handle ->{
                    handle.execute("CREATE TABLE IF NOT EXISTS users (id bigint auto_increment, username varchar(255), password varchar(255), firstName varchar(255), lastName varchar(255), email varchar(255), primary key(id));");
                });
    }

    @Override
    public User addUser(User user) {
        Long id = jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("INSERT INTO users (username, password, firstName, lastName, email) VALUES (:username, :password, :firstName, :lastName, :email)")
                                .bind("username", user.getUsername())
                                .bind("password", user.getPassword())
                                .bind("firstName", user.getFirstName())
                                .bind("lastName", user.getLastName())
                                .bind("email", user.getEmail())
                                .executeAndReturnGeneratedKeys("id")
                                .mapTo(Long.class)
                                .one());
        user.setID(id);
        return user;
    }

    @Override
    public User getUser(final String username) {
        return jdbi.withHandle(
                handler ->
                        handler
                                .createQuery("SELECT username, password, firstName, lastName, email FROM users WHERE username = :username")
                                .bind("username", username)
                                .mapToBean(User.class)
                                .one());
    }


    @Override
    public Integer deleteUser(final String username) {
        return jdbi.withHandle(
                handler ->
                        handler
                                .createQuery("DELETE FROM users WHERE username = :username")
                                .bind("username", username)
                                .mapToBean(Integer.class)
                                .one());

    }
}

