package com.example.userapplication.service;

import com.example.userapplication.entities.User;
import com.example.userapplication.payload.UserAgeDto;
import com.example.userapplication.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createOneUser(User user);

    List<User> getUsers(int limit);

    List<UserAgeDto> getUserAges(int age);
}
