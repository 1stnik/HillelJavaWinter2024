package com.exchanger.service;

import com.exchanger.dto.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void addUser(User user);

    List<User> getUsers() ;

    User getUser(String id);

    User editUser(User user);

    void deleteUser(String id);

    boolean userExist(String id);
}
