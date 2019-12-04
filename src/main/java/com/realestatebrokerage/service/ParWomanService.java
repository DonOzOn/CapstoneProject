package com.realestatebrokerage.service;


import com.realestatebrokerage.domain.ParMan;
import com.realestatebrokerage.domain.ParWoman;
import com.realestatebrokerage.repository.ParManRepository;
import com.realestatebrokerage.repository.ParWomanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParWomanService {
    private final Logger log = LoggerFactory.getLogger(ParWomanService.class);

    @Autowired
    private ParWomanRepository parWomanRepository;

    /**
     * Select par of man by ID
     * **/
    public Optional<ParWoman> findByID(Long id){
        return parWomanRepository.findById(id);
    }
}
