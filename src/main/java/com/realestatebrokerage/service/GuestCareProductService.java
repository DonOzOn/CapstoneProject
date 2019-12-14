package com.realestatebrokerage.service;
import com.realestatebrokerage.domain.GuestCareProduct;
import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.domain.ProductPost;
import com.realestatebrokerage.domain.User;
import com.realestatebrokerage.repository.GuestCareProductRepository;
import com.realestatebrokerage.repository.NewRepository;
import com.realestatebrokerage.repository.ProductPostRepository;
import com.realestatebrokerage.repository.UserRepository;
import com.realestatebrokerage.service.dto.GuestCareProductRequestDTO;
import com.realestatebrokerage.service.dto.NewsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class GuestCareProductService {
    private final Logger log = LoggerFactory.getLogger(GuestCareProductService.class);

    @Autowired
    private GuestCareProductRepository guestCareProductRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductPostRepository postRepository;

    /**
     * List all product
     * **/
    public List<GuestCareProduct> findAll(){
        log.debug("getall");
        return guestCareProductRepository.findAllByStatusIsTrue();
    }


    /**
     * get by id
     * **/
    public Optional<GuestCareProduct> findById(Long id){
        log.debug("find by id");
        return guestCareProductRepository.findById(id);
    }
    /**
     * List all guest by date
     * **/
    public List<GuestCareProduct> findAllByDate(Instant from, Instant to){
        log.debug("getall by date: {} {}", from , to);
        return guestCareProductRepository.findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(from, to);
    }


    /**
     * create guest care product
     * */
    public GuestCareProduct createGuestCareProduct(GuestCareProductRequestDTO guestCareProductRequestDTO) {
        GuestCareProduct guestCareProduct = new GuestCareProduct();
        guestCareProduct.setMess(guestCareProductRequestDTO.getMess());
        guestCareProduct.setEmail(guestCareProductRequestDTO.getEmail());
        guestCareProduct.setPhone(guestCareProductRequestDTO.getPhone());
        guestCareProduct.setName(guestCareProductRequestDTO.getName());
        guestCareProduct.setStatus(true);
        if(guestCareProductRequestDTO.getUser() != null){
            User user = userRepository.findById(guestCareProductRequestDTO.getUser()).orElse(null);
            guestCareProduct.setUser(user);
        }
        if(guestCareProductRequestDTO.getProductPost() != null){
            ProductPost productPost = postRepository.findById(guestCareProductRequestDTO.getProductPost()).orElse(null);
            guestCareProduct.setProductPost(productPost);
        }
        return guestCareProductRepository.save(guestCareProduct);
    }

    /**
     * upate guest
     * */
    public Optional<GuestCareProduct> updateGuestCare(GuestCareProductRequestDTO guestCareProductRequestDTO) {
        return Optional.of(guestCareProductRepository.findById(guestCareProductRequestDTO.getId())).filter(Optional::isPresent).map(Optional::get)
            .map(guestCareProduct -> {
                guestCareProduct.setMess(guestCareProductRequestDTO.getMess());
                guestCareProduct.setEmail(guestCareProductRequestDTO.getEmail());
                guestCareProduct.setPhone(guestCareProductRequestDTO.getPhone());
                guestCareProduct.setName(guestCareProductRequestDTO.getName());
                guestCareProduct.setStatus(true);
                if(guestCareProductRequestDTO.getUser() != null){
                    User user = userRepository.findById(guestCareProductRequestDTO.getUser()).orElse(null);
                    guestCareProduct.setUser(user);
                }
                if(guestCareProductRequestDTO.getProductPost() != null){
                    ProductPost productPost = postRepository.findById(guestCareProductRequestDTO.getProductPost()).orElse(null);
                    guestCareProduct.setProductPost(productPost);
                }
                return guestCareProductRepository.save(guestCareProduct);
            });
    }
    /**
     * delete guest
     * */
    public Optional<GuestCareProduct> deleteGuest(Long id) {
        return Optional.of(guestCareProductRepository.findById(id)).filter(Optional::isPresent).map(Optional::get)
            .map(guest -> {
                guest.setStatus(false);
                return guestCareProductRepository.save(guest);
            });

    }

    public Page<GuestCareProduct> getAllGuest(Long userId, Pageable pageable) {
        return guestCareProductRepository.findAllGuest(userId, pageable);
    }


}
