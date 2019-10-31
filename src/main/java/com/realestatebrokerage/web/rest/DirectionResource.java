package com.realestatebrokerage.web.rest;


import com.realestatebrokerage.domain.Direction;
import com.realestatebrokerage.service.DirectionService;
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
public class DirectionResource {
    private final Logger log = LoggerFactory.getLogger(DirectionResource.class);

    @Autowired
    private DirectionService directionService;

    /**
     * get list direction
     * */
    @GetMapping("/direction")
    public ResponseEntity<List<Direction>> getDirection() {
        log.debug("get list direction : {}");
        return new ResponseEntity<>(directionService.findAll(), HttpStatus.OK);
    }

}
