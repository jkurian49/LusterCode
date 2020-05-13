package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.LusterCode.model.Answer;
import edu.cooper.ee.ece366.LusterCode.model.Post;
import org.jdbi.v3.core.Jdbi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CookieJarJdbi implements CookieJar{

    private final Jdbi jdbi;
    public CookieJarJdbi(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void populateDb() {
        jdbi.useHandle(
                handle ->{
                    handle.execute("CREATE TABLE IF NOT EXISTS cookiejar (id bigint auto_increment, username varchar(255), cookie varchar(255), expiration datetime, primary key(id));");
                });
    }

    @Override
    public Long addCookie(String username, String cookie) {

        Integer exp_time = 6;   //time the cookie will be valid for (in hours)

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime timestamp = LocalDateTime.now();
        LocalDateTime expiration = timestamp.plusHours(exp_time);

        Long id = jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("INSERT INTO cookiejar (username, cookie, expiration) VALUES (:username, :cookie, :expiration)")
                                .bind("username", username)
                                .bind("cookie", cookie)
                                .bind("expiration", expiration)

                                .executeAndReturnGeneratedKeys("id")
                                .mapTo(Long.class)
                                .one());
        return id;
    }

    @Override
    public String getCookie(String username){
        return jdbi.withHandle(
                handler ->
                        handler
                                .createQuery("SELECT cookie FROM cookiejar WHERE username = :username")
                                .bind("username", username)
                                .mapTo(String.class)
                                .one());
    }
}
