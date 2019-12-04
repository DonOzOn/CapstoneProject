package com.realestatebrokerage.service;


import com.realestatebrokerage.domain.ParMan;

import com.realestatebrokerage.repository.ParManRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParManService {
    private final Logger log = LoggerFactory.getLogger(ParManService.class);

    @Autowired
    private ParManRepository parManRepository;

    /**
     * Select par of man by ID
     * **/
    public Optional<ParMan> findByID(Long id){
        return parManRepository.findById(id);
    }
}
