package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.Image;
import com.realestatebrokerage.domain.UsingImage;
import com.realestatebrokerage.repository.ImageRepository;
import com.realestatebrokerage.repository.UsingImageRepository;
import com.realestatebrokerage.service.dto.ImageDTO;
import com.realestatebrokerage.service.dto.UsingImageRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    private final Logger log = LoggerFactory.getLogger(ImageService.class);

    @Autowired
    private ImageRepository imageRepository;


    /**
     * List all product
     * **/
    public List<Image> findAll(){
        return imageRepository.findAll();
    }

    /**
     * get Image
     * **/
    public Optional<Image> findById(Long id){
        return imageRepository.findById(id);
    }


    /**
     * create using image
     * */
    public Image createProduct(ImageDTO imageDTO) {
        Image image = new Image();

        image.setImg1(imageDTO.getImg1());
        image.setImg2(imageDTO.getImg2());
        image.setImg3(imageDTO.getImg3());
        image.setImg4(imageDTO.getImg4());
        image.setImg5(imageDTO.getImg5());
        image.setImg6(imageDTO.getImg6());
        image.setImg7(imageDTO.getImg7());
        image.setImg8(imageDTO.getImg8());
        image.setImg9(imageDTO.getImg9());
        image.setImg10(imageDTO.getImg10());
       return imageRepository.save(image);


    }

    /**
     * create using image
     * */
    public Optional<Image>  updateImage(ImageDTO imageDTO) {
        log.debug("run in update post product: {}", imageDTO);
        return Optional.of(imageRepository.findById(imageDTO.getId())).filter(Optional::isPresent).map(Optional::get)
            .map(image -> {
                image.setImg1(imageDTO.getImg1());
                image.setImg2(imageDTO.getImg2());
                image.setImg3(imageDTO.getImg3());
                image.setImg4(imageDTO.getImg4());
                image.setImg5(imageDTO.getImg5());
                image.setImg6(imageDTO.getImg6());
                image.setImg7(imageDTO.getImg7());
                image.setImg8(imageDTO.getImg8());
                image.setImg9(imageDTO.getImg9());
                image.setImg10(imageDTO.getImg10());
                return imageRepository.save(image);
            });
    }
}
