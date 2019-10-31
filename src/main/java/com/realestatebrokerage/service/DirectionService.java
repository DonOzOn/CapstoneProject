package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.Direction;
import com.realestatebrokerage.repository.DirectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionService {
    private final Logger log = LoggerFactory.getLogger(DirectionService.class);

    @Autowired
    private DirectionRepository directionRepository;

    /**
     * List all direction
     * **/
    public List<Direction> findAll(){
        return directionRepository.findAll();
    }
}
