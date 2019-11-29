package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.dto.UsingImageRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsingImageService {
    private final Logger log = LoggerFactory.getLogger(UsingImageService.class);

    @Autowired
    private UsingImageRepository usingImageRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ProductPostRepository productPostRepository;

    /**
     * List all Using Image
     * **/
    public List<UsingImage> findAll(){
        return usingImageRepository.findAll();
    }

    /**
     * get using Image
     * **/
    public Optional<UsingImage> findByProductPost(Long id){
        return usingImageRepository.findByProductPostId(id);
    }


    /**
     * create using image
     * */
    public UsingImage createUsingImage(UsingImageRequestDTO usingImageRequestDTO) {
        UsingImage usingImage = new UsingImage();

        Image image = imageRepository.findById(usingImageRequestDTO.getImage()).orElse(null);
        usingImage.setImage(image);
        usingImage.setUsingType(null);
        ProductPost productPost = productPostRepository.findById(usingImageRequestDTO.getProductPost()).orElse(null);
        usingImage.setProductPost(productPost);
        return usingImageRepository.save(usingImage);

    }

}
