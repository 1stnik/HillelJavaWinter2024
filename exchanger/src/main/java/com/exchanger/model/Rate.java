package com.exchanger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "rate")
@Accessors(chain = true)
public class Rate extends BaseEntity {
    private CurrencyEnum currency;
    private String sale;
    private String buy;
    private Timestamp receive;
}
