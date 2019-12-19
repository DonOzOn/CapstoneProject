package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.Authority;
import com.realestatebrokerage.domain.Notification;
import com.realestatebrokerage.domain.User;
import com.realestatebrokerage.security.AuthoritiesConstants;
import com.realestatebrokerage.service.NotificationService;
import com.realestatebrokerage.service.UserService;
import com.realestatebrokerage.service.dto.NotificationRequestDTO;
import com.realestatebrokerage.service.dto.NotificationResponeDTO;
import com.realestatebrokerage.service.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NotificationResource {
    private final Logger log = LoggerFactory.getLogger(NotificationResource.class);

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;
    @GetMapping("/sendTopic")
    public void sendTopic(String token, String title , String content, Integer type) {
        notificationService.sendNoti(null, token,title,content, type);
    }

    @PostMapping("/sendTopic")
    public ResponseEntity<Notification> sendTopic(@RequestBody NotificationRequestDTO notificationRequestDTO) {
        Notification notification = notificationService.createdNoti(notificationRequestDTO);
        Optional<User> user = userService.findUserByID(notificationRequestDTO.getUserReceive());
        log.debug("send message noti: {}", notificationRequestDTO.toString());
        log.debug("message noti: {}", notification.toString());
        if(notification.getUserSend() == null){
            notification.setUserSend(new User("Người lạ ",null,null,null,null,null,null,null,null,null,true,null,true,null,null,null,null,null,null));
        }
        String token = user.get().getToken();
        String title = notificationRequestDTO.getTitle();
        String content = notificationRequestDTO.getContent();
        Integer type = notificationRequestDTO.getType();
        notificationService.sendNoti(notification.getUserSend().getLogin(), token,title,content, type);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

    @PostMapping("/sendTopicToUser")
    public ResponseEntity<Void> sendTopicToUser(@RequestBody NotificationRequestDTO notificationRequestDTO) {
        List<User> userList = userService.findAll();
        for (User user:
             userList) {
            Set<Authority> currentUserAuthorities = user.getAuthorities();
            for(Authority auth : currentUserAuthorities) {
                // delete user if it is a student
                if(auth.getName().equals(AuthoritiesConstants.USER)) {
                    notificationRequestDTO.setUserReceive(user.getId());
                    notificationService.createdNoti(notificationRequestDTO);
                    Optional<User> userNoti = userService.findUserByID(notificationRequestDTO.getUserReceive());
                    String token = userNoti.get().getToken();
                    String title = notificationRequestDTO.getTitle();
                    String content = notificationRequestDTO.getContent();
                    Integer type = notificationRequestDTO.getType();
                    notificationService.sendNoti("Admin", token,title,content, type);
                }
            }
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/notification")
    public ResponseEntity<List<NotificationResponeDTO>> filter(Pageable pageable) {
        log.debug("REST request to get notification:");
        final Page<NotificationResponeDTO> page = notificationService.filter(pageable).map(NotificationResponeDTO::new);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/notification");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/notification/status")
    public ResponseEntity<List<NotificationResponeDTO>> filterByStatus(Pageable pageable) {
        log.debug("REST request to get notification:");
        final Page<NotificationResponeDTO> page = notificationService.filterByStatus(pageable).map(NotificationResponeDTO::new);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/notification");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }


    /**
     * {@code PUT /notification} : delete an existing Notification.
     *
     * @param id the notification to delete.
     */
    @DeleteMapping("/notification/{id}")
    public ResponseEntity<Optional<NotificationResponeDTO>> deleteNoti(@PathVariable Long id) {
        log.debug("REST request to delete Noti : {}", id);
        notificationService.deleteNoti(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
