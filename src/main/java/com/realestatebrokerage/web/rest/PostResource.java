package com.realestatebrokerage.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.service.*;
import com.realestatebrokerage.service.dto.*;
import com.realestatebrokerage.web.rest.errors.EmailAlreadyUsedException;
import com.realestatebrokerage.web.rest.errors.LoginAlreadyUsedException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import javafx.geometry.Pos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    /**
     * {@code GET /Post} : get all Post.
     *
     */
    @GetMapping("/product-post")
    public ResponseEntity<List<PostResponeDTO>> getAllPostProduct() {
        List<PostResponeDTO> responeDTOList =  new ArrayList<>();
        List<ProductPostResponseDTO> postList =  productPostService.findAll().stream()
            .map(ProductPostResponseDTO::new).collect(Collectors.toList());
        for (ProductPostResponseDTO pr: postList) {
            PostResponeDTO postResponeDTO = new PostResponeDTO();
            postResponeDTO.setProductPostResponseDTO(pr);
            ProductResponseDTO productResponseDTO = productService.findByID(pr.getProduct().getId()).map(ProductResponseDTO::new).orElse(null);
            postResponeDTO.setProductResponseDTO(productResponseDTO);
            UsingImageResponseDTO usingImageResponseDTO = usingImageService.findByProductPost(pr.getId()).map(UsingImageResponseDTO::new).orElse(null);
            postResponeDTO.setUsingImageResponseDTO(usingImageResponseDTO);
            ImageDTO imageDTO = imageService.findById(usingImageResponseDTO.getImage().getId()).map(ImageDTO::new).orElse(null);
            postResponeDTO.setImageDTO(imageDTO);
            responeDTOList.add(postResponeDTO);
        }
        return new ResponseEntity<>(responeDTOList, HttpStatus.OK);
    }

    /**
     * {@code PUT /product-post} : Updates an product post.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated user.
     * @throws com.realestatebrokerage.web.rest.errors.EmailAlreadyUsedException {@code 400 (Bad Request)} if the email is already in use.
     * @throws LoginAlreadyUsedException {@code 400 (Bad Request)} if the login is already in use.
     */
    @PutMapping("/product-post")
    public ResponseEntity<PostResponeDTO> updateUser(@RequestBody PostRequestDTO postRequestDTO) {
        log.debug("REST request to update Post : {}", postRequestDTO);
        PostResponeDTO postResponeDTO = new PostResponeDTO();
        postRequestDTO.getProductPostRequestDTO().setProduct(postRequestDTO.getProductRequestDTO().getId());
        Optional<ProductPostResponseDTO> productPostResponseDTO = productPostService.update(postRequestDTO.getProductPostRequestDTO()).map(ProductPostResponseDTO::new);
        Optional<ProductResponseDTO> product = productService.updateProduct(postRequestDTO.getProductRequestDTO()).map(ProductResponseDTO::new);
        Optional<ImageDTO> image = imageService.updateImage(postRequestDTO.getImageDTO()).map(ImageDTO::new);
        Optional<UsingImageResponseDTO> usingImageResponseDTO = usingImageService.findByProductPost(postRequestDTO.getProductRequestDTO().getId()).map(UsingImageResponseDTO::new);

        postResponeDTO.setProductPostResponseDTO(productPostResponseDTO.get());
        postResponeDTO.setProductResponseDTO(product.get());
        postResponeDTO.setImageDTO(image.get());
        postResponeDTO.setUsingImageResponseDTO(usingImageResponseDTO.get());

        return new ResponseEntity<>(postResponeDTO, HttpStatus.OK);
    }


}
