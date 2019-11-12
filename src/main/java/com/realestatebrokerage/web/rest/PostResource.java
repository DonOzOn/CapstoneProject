package com.realestatebrokerage.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.service.*;
import com.realestatebrokerage.service.dto.*;
import com.realestatebrokerage.service.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
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
        ProductPost productPost = productPostService.createProductPost(postRequestDTO.getProductPostRequestDTO());
        /**
         * insert image
         * */
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

//    @GetMapping("/listproduct")
//    public List<ProductPostResponseDTO> getListProductPost(){
//        List product = new ArrayList();
//        product = productPostService.findAll();
//        return product;
//    }

    @GetMapping("/listproduct")
//    @PreAuthorize("hasAnyAuthority(\"" + AuthoritiesConstants.VIEW_CUSTOMER+"\",\"" + AuthoritiesConstants.ADMIN+"\")")
    public ResponseEntity<List<ProductPostResponseDTO>> filter(Pageable pageable) {
        log.debug("REST request to get customer: {}");
        final Page<ProductPostResponseDTO> page = productPostService.filter(pageable).map(ProductPostResponseDTO::new);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/listproduct");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}