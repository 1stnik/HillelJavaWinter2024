package com.exchanger.controller;

import com.exchanger.dto.TransferApproveDto;
import com.exchanger.dto.TransferDto;
import com.exchanger.dto.UserDto;
import com.exchanger.dto.records.UserRecord;
import com.exchanger.service.UserService;
import com.exchanger.service.WalletService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
@Slf4j
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/get")
    public Long getMoney(@RequestBody TransferDto transferDto) {
        return walletService.getMoney(transferDto);
    }

    @PostMapping("/put")
    public Long put(@RequestBody TransferDto transferDto) {
        return walletService.putMoney(transferDto);
    }

    @PostMapping("/transfer")
    public Long transfer(@RequestBody TransferDto transferDto) {
        return walletService.transfer(transferDto);
    }


    @PostMapping("/transfer/approve")
    public Long transferApprove(@RequestBody TransferApproveDto transferDto) {
        return walletService.transferApprove(transferDto);
    }
}
