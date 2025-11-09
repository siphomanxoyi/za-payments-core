package com.sipho.za.payments.core.service;

import com.sipho.za.payments.core.dto.UserDto;
import com.sipho.za.payments.core.dto.UserRequest;

public interface UserService {
    UserDto createUser(UserRequest userRequest);
}
