package com.example.userapplication.service.impl;

import com.example.userapplication.entities.User;
import com.example.userapplication.payload.UserAgeDto;
import com.example.userapplication.payload.UserDto;
import com.example.userapplication.repository.UserRepository;
import com.example.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createOneUser(User user) {
        User user1=mapToEntity(user);
        User userEntity = userRepository.save(user1);
        UserDto dto=mapToDto(userEntity);
        return dto;
    }

    @Override
    public List<User> getUsers(int limit) {
        return userRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<UserAgeDto> getUserAges(int age) {
        List<User> users=userRepository.findAll();
        List<UserAgeDto> userAges = new ArrayList<>();

        for (User user : users) {
            int calculateAge=calculateAge(user.getDob());
            if(calculateAge>age){
                UserAgeDto userAge = new UserAgeDto();
                userAge.setName(user.getName());
                userAge.setAge(calculateAge(user.getDob()));
                userAges.add(userAge);
            }
        }
        return userAges;

    }
    private int calculateAge(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth,LocalDate.now()).getYears();
    }


    private UserDto mapToDto(User userEntity) {
        UserDto dto=new UserDto();
        dto.setId(userEntity.getId());
        dto.setName(userEntity.getName());
        dto.setEmail(userEntity.getEmail());
        dto.setDob(userEntity.getDob());
        return dto;
    }

    private User mapToEntity(User user) {
        User u=new User();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setDob(user.getDob());
        return u;
    }
}
