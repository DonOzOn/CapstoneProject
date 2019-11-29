package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.dto.ProductRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private UtilitiesRepository utilitiesRepository;

    /**
     * List all product
     * **/
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    /**
     * List all product by product type
     * **/
    public List<Product> findAllByProdcutType(Long id){
        return productRepository.findAllByProductTypeId(id);
    }

    /**
     * List all product by product type child
     * **/
    public List<Product> findAllByProdcutTypeChild(Long id){
        return productRepository.findAllByProductTypeChildId(id);
    }

    /**
     * get  product by id
     * **/
    public Optional<Product> findByID(Long id){
        return productRepository.findById(id);
    }

    /**
     * create product
     * */
    public Product createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        List<Utilities> utilities = new ArrayList<>();
        product.setPrice(productRequestDTO.getPrice());
        product.setArea(productRequestDTO.getArea());
        Direction direction = directionRepository.findById(productRequestDTO.getDirection()).orElse(null);
        product.setDirection(direction);
        LegalStatus legalStatus = legalStatusRepository.findById(productRequestDTO.getLegalStatus()).orElse(null);
        product.setLegalStatus(legalStatus);
        product.setNumberFloor(productRequestDTO.getNumberFloor());
        product.setNumberBedroom(productRequestDTO.getNumberBedroom());
        product.setNumberBathroom(productRequestDTO.getNumberBathroom());
        ProductType productType = productTypeRepository.findById(productRequestDTO.getProductType()).orElse(null);
        product.setProductType(productType);
        ProductTypeChild productTypeChild = productTypeChildRepository.findById(productRequestDTO.getProductTypeChild()).orElse(null);
        product.setProductTypeChild(productTypeChild);
        product.setStatus(productRequestDTO.isStatus());

        for (Long id: productRequestDTO.getUtilities()) {
            Utilities utilitiesSearch = utilitiesRepository.findById(id).orElse(null);
            utilities.add(utilitiesSearch);
            System.out.println("utilities : " + utilities.toString());
        }
        product.setUtilities(utilities);
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(ProductRequestDTO productRequestDTO){
        List<Utilities> utilities = new ArrayList<>();
        return Optional.of(productRepository.findById(productRequestDTO.getId())).filter(Optional::isPresent).map(Optional::get)
            .map(product -> {
                product.setPrice(productRequestDTO.getPrice());
                product.setArea(productRequestDTO.getArea());
                Direction direction = directionRepository.findById(productRequestDTO.getDirection()).orElse(null);
                product.setDirection(direction);
                LegalStatus legalStatus = legalStatusRepository.findById(productRequestDTO.getLegalStatus()).orElse(null);
                product.setLegalStatus(legalStatus);
                product.setNumberFloor(productRequestDTO.getNumberFloor());
                product.setNumberBedroom(productRequestDTO.getNumberBedroom());
                product.setNumberBathroom(productRequestDTO.getNumberBathroom());
                ProductType productType = productTypeRepository.findById(productRequestDTO.getProductType()).orElse(null);
                product.setProductType(productType);
                ProductTypeChild productTypeChild = productTypeChildRepository.findById(productRequestDTO.getProductTypeChild()).orElse(null);
                product.setProductTypeChild(productTypeChild);
                for (Long id: productRequestDTO.getUtilities()) {
                    Utilities utilitiesSearch = utilitiesRepository.findById(id).orElse(null);
                    utilities.add(utilitiesSearch);
                    System.out.println("utilities : " + utilities);
                }
                product.setUtilities(utilities);
                return productRepository.save(product);
            });
    }
}
