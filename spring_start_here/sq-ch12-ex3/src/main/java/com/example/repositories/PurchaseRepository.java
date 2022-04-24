package com.example.repositories;

import com.example.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    /**
     * @return  The method returns the records it retrieves from the database in a list of {@link Purchase} objects.
     */
    public List<Purchase> findAllPurchases() {
        // We define the SELECT query to get all the records from the purchase table.
        String sql = "SELECT * FROM purchase";

        // We implement a RowMapper object that tells JdbcTemplate how to map a row in the result set into a Purchase
        // object. In the lambda expression, parameter "r" is the ResultSet (the data you get from the database),
        // while parameter "i" is an int representing the row number.
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            // We set the data into a Purchase instance. JdbcTemplate will use this logic for each row in the result
            // set.
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        // We send the SELECT query using the query method, and we provide the row mapper object for JdbcTemplate to
        // know how to transform the data it gets in Purchase objects.
        return jdbc.query(sql, purchaseRowMapper);
    }
}
