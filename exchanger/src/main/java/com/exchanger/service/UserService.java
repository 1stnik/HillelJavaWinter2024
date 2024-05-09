package com.exchanger.service;

import com.exchanger.dto.UserDto;
import com.exchanger.dto.records.UserRecord;
import java.util.List;

public interface UserService {

    long createUser(UserRecord user);

    List<UserDto> getUsers();

    UserDto getUserById(Long id);
}
