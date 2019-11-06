package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.Utilities;
import com.realestatebrokerage.repository.UtilitiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilitiesService {
    private final Logger log = LoggerFactory.getLogger(UtilitiesService.class);

    @Autowired
    private UtilitiesRepository utilitiesRepository;

    /**
     * List all utilities
     * **/
    public List<Utilities> findAll(){
        return utilitiesRepository.findAll();
    }
}
