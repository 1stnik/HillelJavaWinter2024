package com.exchanger.repository;

import com.exchanger.model.CurrencyEnum;
import com.exchanger.model.User;
import com.exchanger.model.Wallet;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByUserAndCurrency(User user, CurrencyEnum currency);

}
