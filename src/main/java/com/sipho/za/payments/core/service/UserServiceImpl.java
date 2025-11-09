package com.sipho.za.payments.core.service;

import com.sipho.za.payments.core.dto.UserDto;
import com.sipho.za.payments.core.dto.UserRequest;
import com.sipho.za.payments.core.mapper.UserMapper;
import com.sipho.za.payments.core.model.User;
import com.sipho.za.payments.core.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserRequest userRequest) {
        if(userRequest == null) {
            throw new IllegalArgumentException("User request cannot be null");
        }
        Optional<User> existingUser = userRepository.findByEmail(userRequest.email());
        if(existingUser.isPresent()) {
            throw new IllegalArgumentException("User with email " + userRequest.email() + " already exists");
        }
        var savedEntity = userRepository.save(userMapper.toEntity(userRequest));
        return userMapper.toDto(savedEntity);
    }
}
