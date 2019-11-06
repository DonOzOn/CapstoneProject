package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.Product;
import com.realestatebrokerage.domain.ProductPost;
import com.realestatebrokerage.domain.Utilities;
import com.realestatebrokerage.service.ProductPostService;
import com.realestatebrokerage.service.ProductService;
import com.realestatebrokerage.service.UtilitiesService;
import com.realestatebrokerage.service.dto.ProductPostRequestDTO;
import com.realestatebrokerage.service.dto.ProductPostResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductPostResource {
    private final Logger log = LoggerFactory.getLogger(ProductPostResource.class);

    @Autowired
    private ProductPostService productPostService;

    /**
     * create product post
     * */
    @PostMapping("/product-post")
    public ResponseEntity <ProductPostResponseDTO> createTimesheet(@RequestBody ProductPostRequestDTO productPostRequestDTO) throws URISyntaxException{
        log.debug("create  product post : {}");
        ProductPost productPost = productPostService.createProductPost(productPostRequestDTO);
        ProductPostResponseDTO newProductPost = new ProductPostResponseDTO(productPost);
        return new ResponseEntity<>(newProductPost, HttpStatus.OK);
    }

}
