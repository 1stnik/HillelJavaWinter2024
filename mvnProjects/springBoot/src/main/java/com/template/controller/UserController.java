package com.template.controller;

import com.template.dto.User;
import com.template.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUser() {
        return userService.getUsers();
    }

    @PostMapping
    public UUID addUser(@RequestBody User user) {
        UUID id = UUID.randomUUID();
        user.setId(id.toString());
        userService.addUser(user);
        return id;
    }
}
