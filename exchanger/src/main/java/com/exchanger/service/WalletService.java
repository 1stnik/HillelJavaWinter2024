package com.exchanger.service;

import com.exchanger.dto.TransferDto;

public interface WalletService {
    Long putMoney(TransferDto transferDto);
    Long getMoney(TransferDto transferDto);

}
