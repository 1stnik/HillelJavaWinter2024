package com.exchanger.service;

import com.exchanger.dto.TransferApproveDto;
import com.exchanger.dto.TransferDto;

public interface WalletService {
    Long putMoney(TransferDto transferDto);
    Long getMoney(TransferDto transferDto);
    Long transfer(TransferDto transferDto);
    Long transferApprove(TransferApproveDto transferDto);
}
