package me.hyunbin.springbootmongo;

import me.hyunbin.springbootmongo.account.Account;
import me.hyunbin.springbootmongo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootmongoApplication {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmongoApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){
		return args -> {
			Account account = new Account();
			account.setEmail("fdfdfdf@bbb");
			account.setUsername("aasdfdaaa");

//			mongoTemplate.insert(account);
			accountRepository.insert(account);

			System.out.println("finished");


		};
	}
}
