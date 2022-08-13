package com.lukas.shopsystem.service;

import com.lukas.shopsystem.model.Student;
import com.lukas.shopsystem.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    User getUserById(Long id);

    boolean deleteUser(Long id);

    User updateUser(Long id, User user);
}
