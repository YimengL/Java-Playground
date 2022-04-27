package com.example.repositories;


import com.example.model.Account;
import com.example.repositories.mappers.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * We add a bean of this class in the Spring context using the {@code @Repository} annotation to later inject this bean
 * where we use it in the service class.
 */
@Repository
public class AccountRepository {

    private final JdbcTemplate jdbc;

    /**
     * We use constructor dependency injection to get a {@link JdbcTemplate} object to work with database.
     */
    @Autowired
    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * We get the details of an account by sending the SELECT query to the DBMS using the
     * {@link JdbcTemplate#queryForObject(String, RowMapper, Object...)} method. We also need to provide a
     * {@link RowMapper} to tell {@link JdbcTemplate} how to map a row in the result to our model object.
     */
    public Account findAccountByuId(long id) {
        String sql = "SELECT * FROM account where id = ?";
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }


    /**
     * We change the amount of an account by sending an UPDATE query to the DBMS using the
     * {@link JdbcTemplate#update(String, Object...)} method.
     */
    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql, amount, id);
    }


    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccountRowMapper());
    }
}
