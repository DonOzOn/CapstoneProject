package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.dto.ProductRequestDTO;
import com.realestatebrokerage.service.dto.UsingImageRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsingImageService {
    private final Logger log = LoggerFactory.getLogger(UsingImageService.class);

    @Autowired
    private UsingImageRepository usingImageRepository;
    @Autowired
    private ImageRepository imageRepository;

    /**
     * List all product
     * **/
    public List<UsingImage> findAll(){
        return usingImageRepository.findAll();
    }

    /**
     * create using image
     * */
    public UsingImage createProduct(UsingImageRequestDTO usingImageRequestDTO, ProductPost productPost) {
        UsingImage usingImage = new UsingImage();

        Image image = imageRepository.findById(usingImageRequestDTO.getImage().toString()).orElse(null);
        usingImage.setImage(image);
        usingImage.setUsingType(null);
        usingImage.setProductPost(productPost);
        return usingImageRepository.save(usingImage);

    }
}
