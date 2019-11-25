package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.District;
import com.realestatebrokerage.domain.New;
import com.realestatebrokerage.domain.Province;
import com.realestatebrokerage.domain.Ward;
import com.realestatebrokerage.service.DistrictService;
import com.realestatebrokerage.service.NewService;
import com.realestatebrokerage.service.ProvinceService;
import com.realestatebrokerage.service.WardService;
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
public class NewResource {
    private final Logger log = LoggerFactory.getLogger(NewResource.class);

    @Autowired
    private NewService newService;



    @GetMapping("/news")
    public ResponseEntity<List<New>> getNews() {
        log.debug("get list news : {}");
        return new ResponseEntity<>(newService.findAll(), HttpStatus.OK);
    }



}
