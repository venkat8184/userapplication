package com.example.userapplication.controller;

import com.example.userapplication.entities.User;
import com.example.userapplication.payload.UserAgeDto;
import com.example.userapplication.payload.UserDto;
import com.example.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createOneUser(@RequestBody User user){
        UserDto dto=userService.createOneUser(user);
        return new ResponseEntity<UserDto>(dto, HttpStatus.CREATED);
    }
    @GetMapping
    public List<User> getUsers(@RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        return userService.getUsers(limit);
    }
    @GetMapping("/ages")
    public ResponseEntity<List<UserAgeDto>> getUserAges(@RequestParam(value = "gt", required = false) Integer age) {
        List<UserAgeDto> userAges = userService.getUserAges(age);
        return ResponseEntity.ok(userAges);
    }

}
