package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.dto.ProductPostRequestDTO;
import com.realestatebrokerage.service.dto.ProductPostResponseDTO;
import liquibase.util.Validate;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EntityManager entityManager;

    /**
     * List all product post
     * **/
    public List<ProductPost> findAll(){
        return productPostRepository.findAll();
    }
    /**
     * List all product post by date from to
     * **/
    public List<ProductPost> findAllFromTo(Instant from, Instant to){
        return productPostRepository.findAllByStatusIsTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(from, to);
    }

    /**
     * List all product post by date from to
     * **/
    public List<ProductPost> findAllByUserID(Long id){
        return productPostRepository.findAllByUserId(id);
    }

    /**
     * List all product post by product id
     * **/
    public Optional<ProductPost> findAllByProduct(Long id, Long typePost){
        return productPostRepository.findAllByStatusTrueAndProductIdAndProductPostTypeId(id, typePost);
    }

    /**
     * List all product post by product id
     * **/
    public List<ProductPost> findAllByProductPostType(Long id){
        return productPostRepository.findAllByProductPostType(id);
    }

    /**
     * List all product post by product id
     * **/
    public List<ProductPost> findAllByProvince(String id){
        return productPostRepository.findAllByProvince(id);
    }

    /**
     * get product post by id
     * **/
    public Optional<ProductPost> findByID(Long id){
        return productPostRepository.findById(id);
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
        if(productPostRequestDTO.getWard() != null){
            Ward ward = wardRepository.findById(productPostRequestDTO.getWard()).orElse(null);
            productPost.setWard(ward);
        }
        if(productPostRequestDTO.getDistrict() != null){
            District district = districtRepository.findById(productPostRequestDTO.getDistrict()).orElse(null);
            productPost.setDistrict(district);
        }
        if(productPostRequestDTO.getProvince() != null){
            Province province = provinceRepository.findById(productPostRequestDTO.getProvince()).orElse(null);
            productPost.setProvince(province);
        }

        if(productPostRequestDTO.getProduct() != null){
            Product product = productRepository.findById(productPostRequestDTO.getProduct()).orElse(null);
            productPost.setProduct(product);
        }
        productPost.setAddress(productPostRequestDTO.getAddress());
        productPost.setShortDescription(productPostRequestDTO.getShortDescription());
        productPost.setContent(productPostRequestDTO.getContent());
        productPost.setStatus(productPostRequestDTO.isStatus());
        return productPostRepository.save(productPost);
    }

    /**
     * update product post
     * */
    public Optional<ProductPost>  update(ProductPostRequestDTO postRequestDTO) {
        log.debug("run in update post product: {}", postRequestDTO);
        return Optional.of(productPostRepository.findById(postRequestDTO.getId())).filter(Optional::isPresent).map(Optional::get)
            .map(productPost -> {
                productPost.setProjectName(postRequestDTO.getProjectName());
                ProductPostType typeChoose = productPostTypeRepository.findById(postRequestDTO.getProductPostType()).orElse(null);
                productPost.setProductPostType(typeChoose);
                productPost.setProductPostTitle(postRequestDTO.getProductPostTitle());
                productPost.setTotalLike(postRequestDTO.getTotalLike());
                productPost.setTypeDeal(postRequestDTO.getTypeDeal());
                productPost.setTotalReport(postRequestDTO.getTotalReport());
                productPost.setTotalShare(productPost.getTotalShare());
                productPost.setProjectName(postRequestDTO.getProjectName());
                if(postRequestDTO.getWard() != null){
                    Ward ward = wardRepository.findById(postRequestDTO.getWard()).orElse(null);
                    productPost.setWard(ward);
                }
                if(postRequestDTO.getDistrict() != null){
                    District district = districtRepository.findById(postRequestDTO.getDistrict()).orElse(null);
                    productPost.setDistrict(district);
                }
                if(postRequestDTO.getProvince() != null){
                    Province province = provinceRepository.findById(postRequestDTO.getProvince()).orElse(null);
                    productPost.setProvince(province);
                }

                if(postRequestDTO.getProduct() != null){
                    Product product = productRepository.findById(postRequestDTO.getProduct()).orElse(null);
                    productPost.setProduct(product);
                }
                productPost.setAddress(postRequestDTO.getAddress());
                productPost.setShortDescription(postRequestDTO.getShortDescription());
                productPost.setContent(postRequestDTO.getContent());
                productPost.setStatus(postRequestDTO.isStatus());
                return productPostRepository.save(productPost);
            });
    }

    /**
     * delete product post
     * */
    public void  deleteByID(Long id) {
        log.debug("run in delete post product: {}", id);
        Optional.of(productPostRepository.findById(id)).filter(Optional::isPresent).map(Optional::get)
            .map(productPost -> {
                productPost.setStatus(!productPost.isStatus());
                return productPostRepository.save(productPost);
            });
    }
    /**
     * search by key word
     * @return a list of all user
     */
    public List<ProductPostResponseDTO> initializeHibernateSearch(String keyword) {
        try {
            log.debug("Search post by keyword: {}", keyword);
            Validate.notNull(entityManager, "Entity manager can't be null");
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
            QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(User.class)
                .get();

            Query query = qb.keyword()
                .onFields("login", "email", "lastName")
                .matching(keyword)
                .createQuery();

            org.hibernate.search.jpa.FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(query, User.class);
            List<ProductPost> postList = jpaQuery.getResultList();
            List<ProductPostResponseDTO> userDTOList = postList.stream().map(ProductPostResponseDTO::new).collect(Collectors.toList());
            return userDTOList;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
