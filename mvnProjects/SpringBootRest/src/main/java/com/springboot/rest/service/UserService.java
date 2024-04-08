package com.springboot.rest.service;

import com.springboot.rest.exception.UserException;
import com.springboot.rest.dto.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
    UUID addUser(User user);

    List<User> getUsers();

    List<User> getUsers(int limit);

    User getUser(UUID id);

    User editUser(User user) throws UserException;

    void deleteUser(String id);

    boolean userExist(String id);
}
