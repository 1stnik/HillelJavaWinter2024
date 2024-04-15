package com.telegram.example.service;

import com.telegram.example.entity.User;
import com.telegram.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
       return userRepository.save(user);

    }

    public User getUserByChat(String chatId) {
        return userRepository.getUserByChatId(chatId);

    }
}
