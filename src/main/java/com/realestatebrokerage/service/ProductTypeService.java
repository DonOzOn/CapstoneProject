package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.ProductType;
import com.realestatebrokerage.repository.ProductTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    private final Logger log = LoggerFactory.getLogger(WardService.class);

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> findAll(){
        return productTypeRepository.findAll();
    }
}
