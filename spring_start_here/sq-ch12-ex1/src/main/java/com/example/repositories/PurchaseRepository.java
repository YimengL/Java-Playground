package com.example.repositories;

import com.example.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbc;

    /**
     * @param jdbc  We use constructor injection to get the {@link JdbcTemplate} instance from the application context.
     */
    @Autowired
    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";

        // The JdbcTemplate update() method sends the query to the database server. The first parameter the method gets
        // is the query, and the next parameters are the values for the parameters. These values replace, in the same
        // order, each question mark in the query.
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }
}
