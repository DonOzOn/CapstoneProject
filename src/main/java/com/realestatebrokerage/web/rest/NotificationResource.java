package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.service.NotificationService;
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
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NotificationResource {

    @Autowired
    private NotificationService notificationService;
    @GetMapping("/sendTopic")
    public void sendTopic(String token) {
        notificationService.sendNoti(token,"hello donnv");
    }


}
