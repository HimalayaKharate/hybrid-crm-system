package com.himluck.crm.controller;

import com.himluck.crm.model.User;
import com.himluck.crm.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/crm-api/v1/users")
public class UserController {
    private UserService service;

    public UserController(UserService service){
        this.service= service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByEmail(@PathVariable UUID id){
        User user = service.findUserById(id);
        if(user == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        return ResponseEntity.ok(service.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable UUID id){
        User user = service.findUserById(id);
        service.deleteUser(user);
        if(service.findUserById(user.getId()) != null)
            return ResponseEntity.badRequest().build();
        return  ResponseEntity.ok(user);
    }


}
