package com.ashraf.springbootdemo.service;

import com.ashraf.springbootdemo.model.User;

public interface UserService {

    public User addUser (User user);
    public User editUser (User user);
    public User deleteUser (User user);
    public Iterable<User> getAllUsers();
    public User getUserById(int id);
}
