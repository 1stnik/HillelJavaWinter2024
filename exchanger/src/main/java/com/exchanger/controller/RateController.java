package com.exchanger.controller;

import com.exchanger.service.RateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1/rates")
@RequiredArgsConstructor
@Slf4j
public class RateController {

    private final RateService rateService;

    @GetMapping()
    public void getRates() throws JsonProcessingException {
        rateService.getRates();
    }
}
