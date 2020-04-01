/*
package edu.cooper.ee.ece366.LusterCode.store;

import edu.cooper.ee.ece366.Lustercode.Handler;
import org.jdbi.v3.core.Jdbi;


public class AnswerStoreJdbi extends AnswerStore{

    private final Jdbi jdbi;
    public AnswerStoreJdbi(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public void populateDb() {
        jdbi.withHandle(
                handle ->
                        handle.execute(
                                "create table items (id bigint auto_increment, name varchar(255), cost double );"));
    }

    @Override
    public List<Item> getItems() {
        return jdbi.withHandle(
                handle ->
                        handle.createQuery("select id, name, cost from items").mapToBean(Item.class).list());
    }

    @Override
    public Item getItem(final Long id) {
        return jdbi.withHandle(
                handle ->
                        handle
                                .createQuery("select id, name, cost from items where id = :id")
                                .bind("id", id)
                                .mapToBean(Item.class)
                                .one());
    }

    @Override
    public Item addAnswer(final Handler.CreateItemRequest createItemRequest) {
        return jdbi.withHandle(
                handle ->
                        handle
                                .createUpdate("insert into answer (post, ans) values (:post, :ans)")
                                .bind("post", createItemRequest.getPost())
                                .bind("ans", createItemRequest.getAnswer())
                                .executeAndReturnGeneratedKeys("answerID")
                                .mapToBean(Answer.class)
                                .one());
    }
}
*/
