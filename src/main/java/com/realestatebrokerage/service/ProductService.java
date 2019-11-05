package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.dto.ProductPostRequestDTO;
import com.realestatebrokerage.service.dto.ProductRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private LegalStatusRepository legalStatusRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductTypeChildRepository productTypeChildRepository;

    /**
     * List all product
     * **/
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    /**
     * create product
     * */
    public Product createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();

        product.setPrice(productRequestDTO.getPrice());
        product.setArea(productRequestDTO.getArea());
        Direction direction = directionRepository.findById(productRequestDTO.getDirection().toString()).orElse(null);
        product.setDirection(direction);
        LegalStatus legalStatus = legalStatusRepository.findById(productRequestDTO.getLegalStatus().toString()).orElse(null);
        product.setLegalStatus(legalStatus);
        product.setNumberFloor(productRequestDTO.getNumberFloor());
        product.setNumberBedroom(productRequestDTO.getNumberBedroom());
        product.setNumberBathroom(productRequestDTO.getNumberBathroom());
        ProductType productType = productTypeRepository.findById(productRequestDTO.getProductType().toString()).orElse(null);
        product.setProductType(productType);
        ProductTypeChild productTypeChild = productTypeChildRepository.findById(productRequestDTO.toString()).orElse(null);
        product.setProductTypeChild(productTypeChild);
        product.setStatus(true);

        return productRepository.save(product);
//        return product.getId();
    }
}
