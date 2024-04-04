package com.template.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topic")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }

}
