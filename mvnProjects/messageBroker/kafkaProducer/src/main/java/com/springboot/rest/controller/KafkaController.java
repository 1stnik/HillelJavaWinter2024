package com.exchanger.controller;

import com.exchanger.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

    private final KafkaProducer producer;

    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @PostMapping("/producer")
    public void sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
    }
}
