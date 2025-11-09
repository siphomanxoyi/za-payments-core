package com.sipho.za.payments.core.mapper;

import com.sipho.za.payments.core.dto.UserDto;
import com.sipho.za.payments.core.dto.UserRequest;
import com.sipho.za.payments.core.model.Role;
import com.sipho.za.payments.core.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto (User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null"); // TODO: Create custom exceptions and handle them in global exception handler
        }
        return new UserDto(user.getEmail(), user.getFirstName(), user.getLastName())    ;
    }

    public User toEntity(UserRequest userRequest) {
        if (userRequest == null) {
            throw new IllegalArgumentException("User request cannot be null");
        }

        return User.builder()
                .email(userRequest.email())
                .role(Role.CUSTOMER) // TODO: Have more logic to determine role
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .idNumber(userRequest.email())
                .build();
    }
}
