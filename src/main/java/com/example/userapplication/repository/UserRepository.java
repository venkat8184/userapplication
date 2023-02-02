package com.example.userapplication.repository;

import com.example.userapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    //List<User> findByAgeGreaterThan(int age);
}
