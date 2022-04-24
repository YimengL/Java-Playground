package com.example.model.mappers;

import com.example.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * We implement the {@link RowMapper} contract and provide the model class we map the result row into a generic type.
 */
public class AccountRowMapper implements RowMapper<Account> {

    /**
     * We implement the {@link RowMapper#mapRow(ResultSet, int)} method, which gets the query result as a parameter
     * (shaped as a {@link ResultSet} object) and returns the {@link Account} instance we map the current row to.
     */
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account a = new Account();
        // We map the values on the current result row to the Account's attributes.
        a.setId(rs.getInt("id"));
        a.setName(rs.getString("name"));
        a.setAmount(rs.getBigDecimal("amount"));
        // We return the account instance after mapping the result value
        return a;
    }
}
