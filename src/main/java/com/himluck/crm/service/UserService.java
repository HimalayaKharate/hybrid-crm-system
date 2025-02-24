package com.himluck.crm.service;

import com.himluck.crm.model.User;
import com.himluck.crm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    UserRepository repository;
    public UserService(UserRepository repo){
        this.repository = repo;
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public User findUserById(UUID id){
        return repository.findById(id).orElse(null);
    }

    public User findUserByEmail(String email){
        User user = repository.findByEmail(email).orElse(null);
        return user;
    }

    public User createUser(User user){
        return repository.save(user);
    }

    public void deleteUser(User user) {
        repository.delete(user);

    }
}
