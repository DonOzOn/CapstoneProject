package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.dto.ProductPostRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductPostService {
    private final Logger log = LoggerFactory.getLogger(ProductPostService.class);

    @Autowired
    private ProductPostRepository productPostRepository;
    @Autowired
    private ProductPostTypeRepository productPostTypeRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private UserService userService;

    /**
     * List all product post
     * **/
    public List<ProductPost> findAll(){
        return productPostRepository.findAll();
    }
    /**
     * create product post
     * */
    public ProductPost createProductPost(ProductPostRequestDTO productPostRequestDTO){
        Optional<User> user = userService.getUserWithAuthorities();
        ProductPost productPost = new ProductPost();
        if(user.isPresent()){
            productPost.setUser(user.get());
        }
        productPost.setProjectName(productPostRequestDTO.getProjectName());
        ProductPostType typeChoose = productPostTypeRepository.findById(productPostRequestDTO.getProductPostType()).orElse(null);
        productPost.setProductPostType(typeChoose);
        productPost.setProductPostTitle(productPostRequestDTO.getProductPostTitle());
        productPost.setTotalLike(productPostRequestDTO.getTotalLike());
        productPost.setTypeDeal(productPostRequestDTO.getTypeDeal());
        productPost.setTotalReport(productPostRequestDTO.getTotalReport());
        productPost.setTotalShare(productPost.getTotalShare());
        productPost.setProjectName(productPostRequestDTO.getProjectName());
        Ward ward = wardRepository.findById(productPostRequestDTO.getWard()).orElse(null);
        productPost.setWard(ward);
        District district = districtRepository.findById(productPostRequestDTO.getDistrict()).orElse(null);
        productPost.setDistrict(district);
        Province province = provinceRepository.findById(productPostRequestDTO.getProvince()).orElse(null);
        productPost.setProvince(province);
        productPost.setAddress(productPostRequestDTO.getAddress());
        productPost.setShortDescription(productPostRequestDTO.getShortDescription());
        productPost.setContent(productPostRequestDTO.getContent());
//        productPost.setProduct(null);
        productPost.setStatus(productPostRequestDTO.isStatus());
        return productPostRepository.save(productPost);

    }

    public Page<ProductPost> filter(Pageable pageable) {
        return productPostRepository.filter(pageable);
    }
}
