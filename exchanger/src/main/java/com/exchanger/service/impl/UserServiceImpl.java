package com.exchanger.service.impl;

import com.exchanger.dto.UserDto;
import com.exchanger.dto.records.UserRecord;
import com.exchanger.exception.NotUniqueDataException;
import com.exchanger.exception.UserNotFoundException;
import com.exchanger.mapper.UserMapper;
import com.exchanger.model.CurrencyEnum;
import com.exchanger.model.User;
import com.exchanger.model.Wallet;
import com.exchanger.repository.UserRepository;
import com.exchanger.repository.WalletRepository;
import com.exchanger.service.UserService;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final UserMapper userMapper;


    @Override
    @Transactional
    public long createUser(UserRecord user) {
        userValidator(user);
        User sUser = userRepository.save(userMapper.forRecord(user).setStatus(true));
        Arrays.stream(CurrencyEnum.values()).forEach(currency -> createWallet(currency, sUser));
        return sUser.getId();
    }

    private void createWallet(CurrencyEnum currency, User user){
        Wallet wallet = new Wallet();
        wallet.setCurrency(currency);
        wallet.setUser(user);
        wallet.setBalance(BigDecimal.ZERO);
        walletRepository.save(wallet);
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

    @Override
    public Optional<User> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByPhone(String phone) {
         return userRepository.findByPhone(phone).orElseThrow(() ->
            new UserNotFoundException("User with phone number " +  phone + " not found"));
    }
}
