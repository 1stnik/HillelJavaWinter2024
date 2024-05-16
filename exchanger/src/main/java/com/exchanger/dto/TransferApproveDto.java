package com.exchanger.dto;

import lombok.Data;

@Data
public class TransferApproveDto {
    private Long transactionId;
    private String phone;
    private String code;
}
