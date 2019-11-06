package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.Image;
import com.realestatebrokerage.domain.ProductPost;
import com.realestatebrokerage.service.ImageService;
import com.realestatebrokerage.service.ProductService;
import com.realestatebrokerage.service.UsingImageService;
import com.realestatebrokerage.service.dto.PostRequestDTO;
import com.realestatebrokerage.service.dto.ProductPostResponseDTO;
import com.realestatebrokerage.service.dto.ProductResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URISyntaxException;

@Controller
@RequestMapping("/api")
public class PostResource {
    private final Logger log = LoggerFactory.getLogger(PostResource.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private UsingImageService usingImageService;

    /**
     * create product post
     * */
    @PostMapping("/product-post")
    public ResponseEntity <ProductPostResponseDTO> createProduct(@RequestBody PostRequestDTO postRequestDTO) throws URISyntaxException{
        log.debug("create  product : {}");
        Image image = imageService.createProduct(postRequestDTO.getImageDTO());

        ProductResponseDTO newProduct = new ProductResponseDTO();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
