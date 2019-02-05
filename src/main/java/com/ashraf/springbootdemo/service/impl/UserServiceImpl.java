package com.ashraf.springbootdemo.service.impl;

import com.ashraf.springbootdemo.exception.ServiceExceptionHolder;
import com.ashraf.springbootdemo.model.User;
import com.ashraf.springbootdemo.repository.UserRepository;
import com.ashraf.springbootdemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public User addUser (User user) {
        return userRepository.save(user);
    }

    public User editUser (User user) {
        return userRepository.save(user);
    }

    public User deleteUser (User user){
        userRepository.delete(user);
        return user;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id){
        //User user = userRepository.getOne(id);
        User user = userRepository.findById(id).orElseThrow(() ->
                new ServiceExceptionHolder.EntityNotFoundException("User",id));
        return user;
    }
}
