package com.exchanger.dto;

import com.exchanger.model.CurrencyEnum;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TransferDto {
    private String phone; // form
    private String destPhone; // to
    private BigDecimal amount;
    private CurrencyEnum currency;
}
