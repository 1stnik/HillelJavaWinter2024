package com.exchanger.service.impl;

import com.exchanger.dto.UserDto;
import com.exchanger.dto.records.UserRecord;
import com.exchanger.exception.NotUniqueDataException;
import com.exchanger.exception.UserNotFoundException;
import com.exchanger.mapper.UserMapper;
import com.exchanger.model.User;
import com.exchanger.repository.UserRepository;
import com.exchanger.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public long createUser(UserRecord user) {
        userValidator(user);
        User sUser = userRepository.save(userMapper.forRecord(user).setStatus(true));

        return sUser.getId();
    }

    private void userValidator(UserRecord user) {
        int count = userRepository.findAllByEmailOrPhone(user.email(), user.phone()).size();

        if (count > 0) {
            throw new NotUniqueDataException();
        }
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserDto::formEntity).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.findById(id).map(UserDto::formEntity).orElseThrow(() ->
            new UserNotFoundException("User with id " + id + " not found"));
    }
}
