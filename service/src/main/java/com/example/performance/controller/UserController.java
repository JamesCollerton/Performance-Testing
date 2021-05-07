package com.example.performance.controller;

import com.example.performance.dto.DisplayableListDto;
import com.example.performance.dto.UserDto;
import com.example.performance.model.User;
import com.example.performance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<DisplayableListDto<UserDto>> getUsers() {

        List<User> users = userService.findAll();

        List<UserDto> userDtos = users.stream().map(User::toDto).collect(Collectors.toList());

        DisplayableListDto<UserDto> displayableListDto = DisplayableListDto.<UserDto>builder().data(userDtos).build();

        return ResponseEntity.ok(displayableListDto);
    }

}
