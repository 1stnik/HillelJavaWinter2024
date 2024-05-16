package com.exchanger.model;

import jakarta.persistence.Column;
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
@Table(name = "transaction")
public class Transaction extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_from")
    private CurrencyEnum currencyFrom;
    private BigDecimal amountFrom;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_to")
    private CurrencyEnum currencyTo;
    private BigDecimal amountTo;

    private String sender;
    private String receiver;

    private String comment;
    private String code;

    private LocalDateTime updateAt;
}
