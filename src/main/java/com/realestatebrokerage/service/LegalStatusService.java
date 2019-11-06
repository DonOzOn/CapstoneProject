package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.LegalStatus;
import com.realestatebrokerage.repository.LegalStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalStatusService {
    private final Logger log = LoggerFactory.getLogger(LegalStatusService.class);

    @Autowired
    private LegalStatusRepository legalStatusRepository;

    /**
     * get all legal status
     * **/
    public List<LegalStatus> findAll(){
        return legalStatusRepository.findAll();
    }
}
