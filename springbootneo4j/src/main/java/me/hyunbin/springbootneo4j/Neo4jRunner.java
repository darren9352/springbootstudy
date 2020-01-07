package me.hyunbin.springbootneo4j;

import me.hyunbin.springbootneo4j.account.Account;
import me.hyunbin.springbootneo4j.account.AccountRepository;
import me.hyunbin.springbootneo4j.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setEmail("aaa@bbb.com");
        account.setUsername("aaa");

        Role role = new Role();
        role.setName("user");

        account.getRoles().add(role);

        accountRepository.save(account);
    }
}
