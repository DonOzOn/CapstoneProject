package com.realestatebrokerage.service;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.Collectors;

import com.google.firebase.messaging.*;
import com.realestatebrokerage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificationService {
    private final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private UserService userService;


    public void sendNoti(String token, String hello_donnv) {

        Message message = Message.builder()
            .setToken(token)
            .setNotification(new com.google.firebase.messaging.Notification(hello_donnv, hello_donnv))
            .build();

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }
}
