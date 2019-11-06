package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.ProductType;
import com.realestatebrokerage.domain.ProductTypeChild;
import com.realestatebrokerage.service.ProductTypeChildService;
import com.realestatebrokerage.service.ProductTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductPostTypeResource {
    private final Logger log = LoggerFactory.getLogger(ProductPostTypeResource.class);

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductTypeChildService productTypeChildService;


    /**
     * Get product type
     * */
    @GetMapping("/product-type")
    public ResponseEntity<List<ProductType>> getProductType() {
        log.debug("get list province : {}");
        return new ResponseEntity<>(productTypeService.findAll(), HttpStatus.OK);
    }

    /**
     * Get product type child
     * */
    @GetMapping("/product-type-child")
    public ResponseEntity<List<ProductTypeChild>> getProductTypeChild(Long productType) {
        log.debug("get list district by province code: {}",productType);
        return new ResponseEntity<>(productTypeChildService.findAllByProductType(productType), HttpStatus.OK);
    }

}
