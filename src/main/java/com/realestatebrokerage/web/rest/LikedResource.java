package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.service.LikedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class LikedResource {
    private final Logger log = LoggerFactory.getLogger(LikedResource.class);

    @Autowired
    private LikedService likedService;


}
