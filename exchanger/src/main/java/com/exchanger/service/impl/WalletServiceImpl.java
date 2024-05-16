package com.exchanger.service.impl;

import com.exchanger.dto.TransferApproveDto;
import com.exchanger.dto.TransferDto;
import com.exchanger.exception.NotEnoughtMoneyException;
import com.exchanger.exception.TransactionNotFoundException;
import com.exchanger.exception.UserNotFoundException;
import com.exchanger.exception.WalletNotFoundException;
import com.exchanger.model.CurrencyEnum;
import com.exchanger.model.Transaction;
import com.exchanger.model.TransactionStatus;
import com.exchanger.model.TransactionType;
import com.exchanger.model.User;
import com.exchanger.model.Wallet;
import com.exchanger.repository.TransactionRepository;
import com.exchanger.repository.UserRepository;
import com.exchanger.repository.WalletRepository;
import com.exchanger.service.UserService;
import com.exchanger.service.WalletService;
import com.exchanger.telegram.TelegramBot;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletServiceImpl implements WalletService {

    @Value("${transaction.fee}")
    private BigDecimal fee;
    @Value("${transaction.min-fee}")
    private BigDecimal minFee;

    private final UserService userService;
    private final WalletRepository walletRepository;
    private final TelegramBot telegramBot;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

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

    @Override
    public Long transfer(TransferDto transferDto) {
        // validate users
        User from = userService.findByPhone(transferDto.getPhone());
        userService.findByPhone(transferDto.getDestPhone());

        balanceValidation(from, transferDto.getCurrency(), transferDto.getAmount());

        Transaction transaction = new Transaction();
        transaction.setSender(transferDto.getPhone());
        transaction.setCurrencyFrom(transferDto.getCurrency());
        transaction.setAmountFrom(transferDto.getAmount());

        transaction.setReceiver(transferDto.getDestPhone());
        transaction.setCurrencyTo(transferDto.getCurrency());
        transaction.setAmountTo(transferDto.getAmount());

        transaction.setType(TransactionType.TRANSF);
        transaction.setStatus(TransactionStatus.PENDING);
        transaction.setCode( RandomStringUtils.randomAlphabetic(6));

        transactionRepository.save(transaction);

        telegramBot.sendMessage(from.getTelegramChatId(), transaction.getCode());

        return transaction.getId();
    }



    @Override
    @Transactional
    public Long transferApprove(TransferApproveDto transferDto) {
        User from = userService.findByPhone(transferDto.getPhone());

        Optional<Transaction> transaction = transactionRepository.findTransactionByIdAndSender(transferDto.getTransactionId(), transferDto.getPhone());

        if (transaction.isEmpty()) {
            throw new TransactionNotFoundException();
        }

        Transaction tran = transaction.get();

        // validate amount
        balanceValidation(from, tran.getCurrencyFrom(), tran.getAmountFrom());

        if (!transferDto.getCode().equals(transferDto.getCode())){
            throw new TransactionNotFoundException();
        }


        Wallet wFrom = walletRepository.findByUserAndCurrency(from, tran.getCurrencyFrom()).orElseThrow(() -> new WalletNotFoundException());
        Wallet wTo = walletRepository.findByUserAndCurrency(userService.findByPhone(tran.getReceiver()), tran.getCurrencyTo()).orElseThrow(() -> new WalletNotFoundException());
        Wallet systemWallet = walletRepository.findByUserAndCurrency(
                userRepository.findById(10L).orElseThrow(() -> new UserNotFoundException("System user not found"))
                , tran.getCurrencyTo())
            .orElseThrow(() -> new WalletNotFoundException());

        BigDecimal fee = calculateFee(tran.getAmountFrom());

        wFrom.setBalance(wFrom.getBalance().subtract(tran.getAmountFrom()));
        wTo.setBalance(wTo.getBalance()
            .add(tran.getAmountFrom())
            .subtract(fee));
        systemWallet.setBalance(systemWallet.getBalance().add(fee));


        walletRepository.save(wFrom);
        walletRepository.save(wTo);
        walletRepository.save(systemWallet);

        tran.setStatus(TransactionStatus.EXECUTED);
        tran.setCode(null);
        tran.setUpdateAt(LocalDateTime.now());
        transactionRepository.save(tran);

        return tran.getId();
    }

    private void balanceValidation(User from, CurrencyEnum currency, BigDecimal amount) {
        // validate amount
        Optional<Wallet> walletOption = walletRepository.findByUserAndCurrency(from,
            currency);

        if (walletOption.isEmpty()) {
            throw new WalletNotFoundException();
        }
        Wallet wallet = walletOption.get();
        BigDecimal balance = wallet.getBalance();

        if (balance.compareTo(amount) < 1) {
            throw new NotEnoughtMoneyException();
        }
    }


    private BigDecimal calculateFee(BigDecimal amount){
        BigDecimal amountFee = amount.multiply(fee).divide(BigDecimal.valueOf(100));

        if (amountFee.compareTo(minFee) < 0){
            return minFee;
        }
        return amountFee;
    }
}
