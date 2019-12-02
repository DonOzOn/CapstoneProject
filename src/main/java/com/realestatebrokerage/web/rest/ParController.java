package com.realestatebrokerage.web.rest;


import com.realestatebrokerage.domain.ParWoman;
import com.realestatebrokerage.service.ParManService;
import com.realestatebrokerage.service.ParWomanService;
import com.realestatebrokerage.service.dto.par_manDTO;
import com.realestatebrokerage.service.dto.par_womanDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ParController {
    private final Logger log = LoggerFactory.getLogger(ParController.class);

    @Autowired
    private ParManService parManService;
    private ParWomanService parWomanService;

    /**
     * get list direction
     *
     * @return*/
//    @GetMapping("/fengshui/{yearitem}")
//    public Optional<ParMan> getPar(@PathVariable("yearitem") Long yearitem) {
//         long parId = 0;
//         long sum = 0;
//         long sotachra;
//         for (;yearitem!=0;){
//             sotachra = yearitem % 10;
//             sum += sotachra;
//             yearitem /= 10;
//         }
//        parId = sum%9;
//        return parManService.findByID(parId);
//    }

    /**
     * {@code GET /Post} : get all Post.
     *
     */
    @GetMapping("/fengshui/man/{yearitem}")
    public ResponseEntity<par_manDTO> getAllPostProductByMan(@PathVariable("yearitem") Long yearitem) {
        long parId = 0;
         long sum = 0;
        long sotachra;
        for (;yearitem!=0;){
             sotachra = yearitem % 10;
            sum += sotachra;
            yearitem /= 10;
       }
          parId = sum%9;
        par_manDTO par_manDTO = parManService.findByID(parId).map(par_manDTO::new).orElse(null);
        return new ResponseEntity<>(par_manDTO, HttpStatus.OK);
    }

    /**
     * {@code GET /Post} : get all Post.
     *
     */
    @GetMapping("/fengshui/woman/{yearitem}")
    public ResponseEntity<par_womanDTO> getAllPostProductBy(@PathVariable("yearitem") Long yearitem) {
        System.out.println(yearitem);
        long parId = 0;
        long sum = 0;
        long sotachra;
        for (;yearitem!=0;){
            sotachra = yearitem % 10;
            sum += sotachra;
            yearitem /= 10;
        }
        parId = sum%9;
        System.out.println(parId);
       par_womanDTO par_womanDTO = parWomanService.findByID(parId).map(par_womanDTO::new).orElse(null);
//        Optional<ParWoman> par_womanDTO = parWomanService.findByID(parId);
        System.out.println(parWomanService.findByID(parId).toString());
        return new ResponseEntity<>(par_womanDTO, HttpStatus.OK);
    }
}
