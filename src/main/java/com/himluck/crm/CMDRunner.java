package com.himluck.crm;

import com.himluck.crm.model.User;
import com.himluck.crm.model.enums.Role;
import com.himluck.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class CMDRunner implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void run(String... args) throws Exception {
        User newUser = new User();
        newUser.setFirstName("john");
        newUser.setLastName("timmy");
        newUser.setRole(Role.ADMIN);
        newUser.setEmail("john@example.com");
        newUser.setPassword(passwordEncoder.encode("mypassword")); // Hashed!
        repository.save(newUser);

    }
}
