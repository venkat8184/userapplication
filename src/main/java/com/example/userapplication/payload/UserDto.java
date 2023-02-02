package com.example.userapplication.payload;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
}
