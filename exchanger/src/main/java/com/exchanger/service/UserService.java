package com.exchanger.service;

import com.exchanger.dto.UserDto;
import com.exchanger.dto.records.UserRecord;
import com.exchanger.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    long createUser(UserRecord user);

    List<UserDto> getUsers();

    UserDto getUserById(Long id);

    Optional<User> getUserByPhone(String phone);

    void saveUser(User user);

    User findByPhone(String phone);
}
