package com.exchanger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.LastModifiedDate;


@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "wallet")
public class Wallet extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
    @LastModifiedDate
    private LocalDateTime lastUpdate = LocalDateTime.now();
    private BigDecimal balance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

}
