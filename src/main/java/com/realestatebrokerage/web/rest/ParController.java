package com.realestatebrokerage.web.rest;


import com.realestatebrokerage.domain.DirectionHouse;
import com.realestatebrokerage.domain.ParMan;
import com.realestatebrokerage.domain.ParWoman;
import com.realestatebrokerage.service.DirectionHouseService;
import com.realestatebrokerage.service.ParManService;
import com.realestatebrokerage.service.ParWomanService;
import com.realestatebrokerage.service.dto.DirectionHouseDTO;
import com.realestatebrokerage.service.dto.ParManDTO;
import com.realestatebrokerage.service.dto.ParWomanDTO;
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
    @Autowired
    private ParWomanService parWomanService;
    @Autowired
    private DirectionHouseService directionHouseService;

    /**
     * get list direction
     *
     * @return*/
//    @GetMapping("/fengshui/man/{yearitem}")
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
    public ResponseEntity<DirectionHouseDTO> getDirectionHouseParMan(@PathVariable("yearitem") Long yearitem) {
        long parId = 0;
         long sum = 0;
        long sotachra;
        for (;yearitem!=0;){
             sotachra = yearitem % 10;
            sum += sotachra;
            yearitem /= 10;
       }
          parId = sum%9;
            if(parId==0){
                parId = 9;
            }

        ParManDTO parManDTO = parManService.findByID(parId).map(ParManDTO::new).orElse(null);


        DirectionHouseDTO directionHouseDTO = directionHouseService.findByNamePar(parManDTO.getNamePar()).map(DirectionHouseDTO::new).orElse(null);

        return new ResponseEntity<>(directionHouseDTO, HttpStatus.OK);
    }
//    @GetMapping("/fengshui/man/{yearitem}")
//    public ResponseEntity<directionHouseDTO> getAllPostProductByMan(@PathVariable("yearitem") Long yearitem) {
//        long parId = 0;
//        long sum = 0;
//        long sotachra;
//        for (;yearitem!=0;){
//            sotachra = yearitem % 10;
//            sum += sotachra;
//            yearitem /= 10;
//        }
//        parId = sum%9;
////        par_manDTO par_manDTO = parManService.findByID(parId).map(par_manDTO::new).orElse(null);
////        System.out.println( par_manDTO.getName_par());
//
//        directionHouseDTO directionHouseDTO = directionHouseService.findByID(parId).map(directionHouseDTO::new).orElse(null);
//        return new ResponseEntity<>(directionHouseDTO, HttpStatus.OK);
//    }
    /**
     * {@code GET /Post} : get all Post.
     *
     */
    @GetMapping("/fengshui/woman/{yearitem}")
    public ResponseEntity<DirectionHouseDTO> getDirectionHouseParWoman(@PathVariable("yearitem") Long yearitem) {
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
        //System.out.println(parId);
        if(parId==0){
            parId = 9;
        }

        ParWoman parWomanDTO = parWomanService.findByID(parId).orElse(null);
        DirectionHouseDTO directionHouseDTO = directionHouseService.findByNamePar(parWomanDTO.getNamePar()).map(DirectionHouseDTO::new).orElse(null);
        //System.out.println(parWomanService.findByID(parId).toString());
        return new ResponseEntity<>(directionHouseDTO, HttpStatus.OK);
    }
}
