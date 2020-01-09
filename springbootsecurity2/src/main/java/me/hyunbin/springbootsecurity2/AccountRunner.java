package me.hyunbin.springbootsecurity2;

import me.hyunbin.springbootsecurity2.account.Account;
import me.hyunbin.springbootsecurity2.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {
    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account hyunbin = accountService.createAccount("hyunbin", "!234");
        System.out.println(hyunbin.getUsername() + " password: " + hyunbin.getPassword());
    }
}
