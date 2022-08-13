package com.lukas.shopsystem.controller;

import com.lukas.shopsystem.model.User;
import com.lukas.shopsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable("id") Long id){
        User user = null;
        user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable("id") Long id){
        boolean deleted = false;
        deleted = userService.deleteUser(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Successfully deleted!", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        user = userService.updateUser(id, user);
        return ResponseEntity.ok(user);
    }
}


    /* Old version

    @Autowired

    private UserService userService;


    @PostMapping("/registration")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New User is added" ;
    }


    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

     */


