package com.telegram.example.service;

import com.telegram.example.dto.NotificationDto;
import com.telegram.example.entity.Notification;
import com.telegram.example.entity.User;
import com.telegram.example.repository.NotificationRepository;
import com.telegram.example.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification saveNotification(Notification notification) {
       return notificationRepository.save(notification);

    }

    public List<NotificationDto> getNotificatoinList(User user){
        return notificationRepository.findAllByUser(user).stream()
            .map(notification -> new NotificationDto(notification.getMessage(), notification.getDate()))
            .toList();
    }


}
