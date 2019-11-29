package com.realestatebrokerage.service;


import com.realestatebrokerage.domain.New;

import com.realestatebrokerage.repository.NewRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService {
    private final Logger log = LoggerFactory.getLogger(NewService.class);

    @Autowired
    private NewRepository newRepository;


    /**
     * List all product
     * **/
    public List<New> findAll(){
        log.debug("getall");
        return newRepository.findAll();
    }

    /**
     * create using image
     * */
//    public New createProduct(NewDTO newDTO) {
//        New news = new New();
//
//
//
//        news.setId(newDTO.getId());
//        news.setContent(newDTO.getContent());
//        news.setDecription(newDTO.getDecription());
//        news.setStatus(newDTO.isStatus());
//        news.setTitle(newDTO.getTitle());
//
//
//       return newRepository.save(news);
//
//
//    }
}
