package me.hyubin.springbootjpa.account;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest // Slicing Test H2 Database
//@SpringBootTest //IntegrationTest postgreSQL
class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        Account account = new Account();
        account.setUsername("hyunbin");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();

        Optional<Account> existAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existAccount).isNotEmpty();
        Optional<Account> nonExistAccount = accountRepository.findByUsername("dddd");
        assertThat(nonExistAccount).isEmpty();
    }
}