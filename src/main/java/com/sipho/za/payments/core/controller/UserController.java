package com.sipho.za.payments.core.controller;

import com.sipho.za.payments.core.dto.UserDto;
import com.sipho.za.payments.core.dto.UserRequest;
import com.sipho.za.payments.core.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest) {
        var userDto = userService.createUser(userRequest);
        return ResponseEntity.ok(userDto);
    }

}
