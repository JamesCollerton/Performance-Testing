package com.example.performance.model;

import com.example.performance.dto.UserDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static UserDto toDto(User user) {
        return UserDto.builder().name(user.getName()).build();
    }
}
