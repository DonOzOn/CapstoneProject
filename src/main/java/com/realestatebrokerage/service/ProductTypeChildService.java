package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.ProductTypeChild;
import com.realestatebrokerage.repository.ProductTypeChildRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeChildService {
    private final Logger log = LoggerFactory.getLogger(ProductTypeChildService.class);
    @Autowired
    private ProductTypeChildRepository productTypeChildRepository;

    public List<ProductTypeChild>  findAllByProductType(Long productType){
        return productTypeChildRepository.findAllByProductType_Id(productType);
    }
}
