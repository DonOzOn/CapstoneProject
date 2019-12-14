package com.realestatebrokerage.service;


import com.realestatebrokerage.domain.User;
import com.realestatebrokerage.repository.NotificationRepository;
import com.realestatebrokerage.service.dto.NotificationRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.firebase.messaging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.realestatebrokerage.domain.Notification;

import java.util.Optional;
import java.util.stream.DoubleStream;

@Service
@Transactional
public class NotificationService {
    private final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private UserService userService;
    @Autowired
    private NotificationRepository notificationRepository;


    public void sendNoti(String sender,String token,String title, String content , Integer type ) {
//        Message message = Message.builder()
//            .setToken(token)
//            .setNotification(new com.google.firebase.messaging.Notification(title,sender + content))
//            .build();
        Message message = Message.builder()
            .putData("score", "850")
            .putData("time", "2:45")
            .setToken(token)
            .setNotification(new com.google.firebase.messaging.Notification(title,sender + content))
            .build();
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }


    public void sendNotiToUser(String title, String content , String token) {
        Message message = Message.builder()
            .setToken(token)
            .setNotification(new com.google.firebase.messaging.Notification(title,content))
            .build();

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }

    public Notification createdNoti(NotificationRequestDTO notificationRequestDTO) {
        Notification notification = new Notification();

        if(notificationRequestDTO.getUserSend() != null) {

            User user = userService.findUserByID(notificationRequestDTO.getUserSend()).orElse(null);
            notification.setUserSend(user);
        }
        if(notificationRequestDTO.getUserReceive() != null) {

            User user = userService.findUserByID(notificationRequestDTO.getUserReceive()).orElse(null);
            notification.setUserReceive(user);
        }
        notification.setContent(notificationRequestDTO.getContent());
        notification.setType(notificationRequestDTO.getType());
        notification.setTitle(notificationRequestDTO.getTitle());
        notification.setStatus(true);
         return notificationRepository.save(notification);
    }

    public Page<Notification> filter(Pageable pageable) {
        Long id = userService.getUserWithAuthorities().get().getId();
        return notificationRepository.findByUser(id, pageable);
    }

    public Page<Notification> filterByStatus(Pageable pageable) {
        Long id = userService.getUserWithAuthorities().get().getId();
        return notificationRepository.findByUserStatusTrue(id, pageable);
    }
    /**
     * delete notification
     * */
    public void deleteNoti(Long id) {
        Optional.of(notificationRepository.findById(id)).filter(Optional::isPresent).map(Optional::get)
            .map(noti -> {
                noti.setStatus(!noti.isStatus());
                return notificationRepository.save(noti);
            });

    }
}
