package com.realestatebrokerage.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.service.*;
import com.realestatebrokerage.service.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private ProductPostService productPostService;

    /**
     * create product post
     * */
    @PostMapping("/product-post")
    public ResponseEntity<PostResponeDTO> createProduct(@RequestBody PostRequestDTO postRequestDTO){
        log.debug("create  product post: {}", postRequestDTO);
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postRequestDTO);
            System.out.println(jsonInString2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * insert product
         * */
        Product product = productService.createProduct(postRequestDTO.getProductRequestDTO());
         /**
         * insert product post
         * */
        postRequestDTO.getProductPostRequestDTO().setProduct(product.getId());
        System.out.println("product.getId() : " + product.getId());
        ProductPost productPost = productPostService.createProductPost(postRequestDTO.getProductPostRequestDTO());
        /**
         * insert image
         * */
//        String filePath="xyz/Test FileUpload/";
//        File saveDir = new File(filePath);
//        if(!saveDir.exists())
//        {
//            saveDir.mkdirs();
//        }
//        for (MultipartFile file : postRequestDTO.getListImage()) {
//            File f= new File(filePath,file.getOriginalFilename());
//            String Filename=file.getOriginalFilename();
//            try {
//                file.transferTo(f); //Transfer or Saving in local memory
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
////your logic here
//        }
        Image image = imageService.createProduct(postRequestDTO.getImageDTO());
        /**
         * insert product
         * */
        postRequestDTO.getUsingImageRequestDTO().setImage(image.getId());
        postRequestDTO.getUsingImageRequestDTO().setProductPost(productPost.getId());
        UsingImage usingImage = usingImageService.createUsingImage(postRequestDTO.getUsingImageRequestDTO());
        /**
         * */
        ProductResponseDTO newProduct = new ProductResponseDTO(product);
        ProductPostResponseDTO newProductPost = new ProductPostResponseDTO(productPost);
        UsingImageResponseDTO newUsingImage = new UsingImageResponseDTO(usingImage);
        ImageDTO newImageDTO = new ImageDTO(image);

        PostResponeDTO newPostRespone = new PostResponeDTO(newProduct,newProductPost,newImageDTO,newUsingImage);
        return new ResponseEntity<>(newPostRespone, HttpStatus.OK);
    }

}
