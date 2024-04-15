package com.telegram.example.telegram;

import com.telegram.example.dto.BotUsersService;
import com.telegram.example.dto.NotificationDto;
import com.telegram.example.entity.Notification;
import com.telegram.example.entity.User;
import com.telegram.example.service.NotificationService;
import com.telegram.example.service.UserService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    private String username;

    @Value("${telegram.bot.token}")
    private String token;

    private final BotUsersService botUsersService;
    private final UserService userService;
    private final NotificationService notificationService;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            log.info("receive from bot : {}", messageText);
            Message message = update.getMessage();

            if (message.getText().equals("/start")) {
                registerUser(message);
            } else if (message.getText().startsWith("/add:")){
                saveMessage(message);
            } else if (message.getText().startsWith("/get")){
                getMessages(message);
            } else {
                SendMessage mes = new SendMessage();
                mes.setChatId(message.getChatId());
                mes.setText("""
                    available command: 
                    /start    -- register user
                    /add: ... -- add notification
                    /get       -- list notifications""");

                executeMessage(mes);
            }
        }
    }

    private void getMessages(Message message) {
        var chatId = message.getChatId().toString();
        User userByChat = userService.getUserByChat(chatId);

        if (userByChat == null){
            User user = new User();
            user.setChatId(message.getChatId().toString());
            user.setName(message.getFrom().getLastName() + " " + message.getFrom().getFirstName());

            userByChat = userService.createUser(user);
        }

        List<NotificationDto> notificatoinList = notificationService.getNotificatoinList(userByChat);

        StringBuilder stringBuilder = new StringBuilder();
        for (NotificationDto notificationDto : notificatoinList) {
            stringBuilder.append(notificationDto.date())
                .append(" - ")
                .append(notificationDto.message())
                .append("\n");
        }
        String result = stringBuilder.toString();

        if (result.isEmpty()){
            result = "No notifications found";
        }

        sendMessage(Long.valueOf(userByChat.getChatId()), result);

    }

    private void saveMessage(Message message) {
        var chatId = message.getChatId().toString();
        User userByChat = userService.getUserByChat(chatId);

        if (userByChat == null){
            User user = new User();
            user.setChatId(message.getChatId().toString());
            user.setName(message.getFrom().getLastName() + " " + message.getFrom().getFirstName());

            userByChat = userService.createUser(user);
        }

        Notification notification = new Notification();
        notification.setUser(userByChat);
        notification.setMessage(message.getText().replaceAll("/add:", ""));
        notification.setDate(LocalDateTime.now());

        notificationService.saveNotification(notification);
    }


    private void registerUser(Message message) {

        User user = userService.getUserByChat(message.getChatId().toString());

        if (user == null){
            user = new User();
            user.setChatId(message.getChatId().toString());
            user.setName(message.getFrom().getLastName() + " " + message.getFrom().getFirstName());

           user = userService.createUser(user);

            SendMessage mes = new SendMessage();
            mes.setChatId(user.getChatId());
            mes.setText("Hello  new user :" + user.getName());
            executeMessage(mes);
        } else {
            SendMessage mes = new SendMessage();
            mes.setChatId(user.getChatId());
            mes.setText("Welcome back:  " + user.getName());
            executeMessage(mes);
        }

    }

    public void sendMessage(long chatId, String textToSend){
               SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        executeMessage(message);
    }

    private void executeMessage(SendMessage message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
