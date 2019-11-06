package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.LegalStatus;
import com.realestatebrokerage.service.LegalStatusService;
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
public class LegalStatusResource {
    private final Logger log = LoggerFactory.getLogger(LegalStatusResource.class);

    @Autowired
    private LegalStatusService legalStatusService;

    /**
     * get list legal status
     * */
    @GetMapping("/legal-status")
    public ResponseEntity<List<LegalStatus>> getLegalStatus() {
        log.debug("get list legal-status : {}");
        return new ResponseEntity<>(legalStatusService.findAll(), HttpStatus.OK);
    }

}
