package com.spibook.core.controller;

import com.spibook.core.dao.exceptions.NoSuchUserException;
import com.spibook.core.dao.exceptions.UserAlreadyExistsException;
import com.spibook.core.entity.User;
import com.spibook.core.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity registerNewUser(@RequestBody User user) throws UserAlreadyExistsException{
            userService.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>( userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") int id) throws NoSuchUserException{
        User us = userService.findUser(id);
    return new ResponseEntity<User>(us, HttpStatus.OK);
    }

}
