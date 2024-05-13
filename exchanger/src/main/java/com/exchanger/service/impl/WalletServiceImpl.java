package com.exchanger.service.impl;

import com.exchanger.dto.TransferDto;
import com.exchanger.exception.WalletNotFoundException;
import com.exchanger.model.User;
import com.exchanger.model.Wallet;
import com.exchanger.repository.WalletRepository;
import com.exchanger.service.UserService;
import com.exchanger.service.WalletService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletServiceImpl implements WalletService {

    private final UserService userService;
    private final WalletRepository walletRepository;

    @Override
    public Long putMoney(TransferDto transferDto) {
        User user = userService.findByPhone(transferDto.getPhone());

        Optional<Wallet> wallet = walletRepository.findByUserAndCurrency(user, transferDto.getCurrency());
        if (wallet.isEmpty()) {
            throw new WalletNotFoundException();
        }
        Wallet wal = wallet.get();
        wal.setBalance(wal.getBalance().add(transferDto.getAmount()));
        walletRepository.save(wal);

        return 0L;
    }

    @Override
    public Long getMoney(TransferDto transferDto) {
        User user = userService.findByPhone(transferDto.getPhone());

        Optional<Wallet> wallet = walletRepository.findByUserAndCurrency(user, transferDto.getCurrency());
        if (wallet.isEmpty()) {
            throw new WalletNotFoundException();
        }
        Wallet wal = wallet.get();
        wal.setBalance(wal.getBalance().subtract(transferDto.getAmount()));
        walletRepository.save(wal);

        return 0L;
    }
}
