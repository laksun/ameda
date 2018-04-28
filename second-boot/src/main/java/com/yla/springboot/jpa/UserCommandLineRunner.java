package com.yla.springboot.jpa;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) {
        // save a couple of customers
        repository.save(new User("yusuf", "Admin"));
        repository.save(new User("levent", "User"));
        repository.save(new User("ahmet", "Admin"));
        repository.save(new User("mehmet", "User"));
        repository.save(new User("abdullah", "User"));
        repository.save(new User("ozer", "Admin"));
        repository.save(new User("gokmen", "User"));

        log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        for (User user : repository.findAll()) {
            log.info(user.toString());
        }
        
        log.info("The admin users are");
        //for (User user : repository.findByRole("Admin")) {
		//	log.info(user.toString());
		//}

    }
}