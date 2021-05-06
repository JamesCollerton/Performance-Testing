package com.example.performance.model;

import com.example.performance.dto.UserDto;
import lombok.Data;

@Data
public class User {
    private String name;

    public static UserDto toDto(User user) {
        return UserDto.builder().name(user.getName()).build();
    }
}
