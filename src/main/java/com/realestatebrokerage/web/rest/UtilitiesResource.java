package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.Utilities;
import com.realestatebrokerage.service.UtilitiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UtilitiesResource {
    private final Logger log = LoggerFactory.getLogger(UtilitiesResource.class);

    @Autowired
    private UtilitiesService utilitiesService;

    /**
     * get list utilities
     * */
    @GetMapping("/utilities")
    public ResponseEntity<List<Utilities>> getProvince() {
        log.debug("get list utilities : {}");
        return new ResponseEntity<>(utilitiesService.findAll(), HttpStatus.OK);
    }

}
