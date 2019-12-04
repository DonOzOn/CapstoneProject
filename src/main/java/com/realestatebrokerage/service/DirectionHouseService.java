package com.realestatebrokerage.service;


import com.realestatebrokerage.domain.DirectionHouse;
import com.realestatebrokerage.domain.ParMan;
import com.realestatebrokerage.repository.DirectionHouseRepository;
import com.realestatebrokerage.repository.ParManRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectionHouseService {
    private final Logger log = LoggerFactory.getLogger(DirectionHouseService.class);

    @Autowired
    private DirectionHouseRepository directionHouseRepository;

    /**
     * Select par of man by ID
     * **/
    public Optional<DirectionHouse> findByNamePar(String parName){
        return directionHouseRepository.findByParName(parName);
    }
}
