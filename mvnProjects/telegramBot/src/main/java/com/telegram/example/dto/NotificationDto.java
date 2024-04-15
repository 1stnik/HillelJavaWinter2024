package com.telegram.example.dto;

import java.time.LocalDateTime;

public record NotificationDto(String message, LocalDateTime date) {

}
