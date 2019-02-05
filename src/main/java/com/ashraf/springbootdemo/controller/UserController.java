package com.ashraf.springbootdemo.controller;

import com.ashraf.springbootdemo.dto.UserDto;
import com.ashraf.springbootdemo.model.User;
import com.ashraf.springbootdemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")
public class UserController {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private UserService userService;


    @GetMapping(path="")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/add")
    public User addUser (@RequestBody UserDto userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userService.addUser(user);
    }

    @GetMapping("/delete/{id}")
    public User deleteUser (@PathVariable int id) {
        User user = userService.getUserById(id);
        if(user!=null){
            userService.deleteUser(user);
        }
        return null;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public User editUser (@RequestBody UserDto userDto) {
        User currentUser = userService.getUserById(userDto.getId());
        if(currentUser!=null){
            currentUser=null;
            currentUser = modelMapper.map(userDto, User.class);
            return userService.editUser(currentUser);
        }
        return null;
    }


}