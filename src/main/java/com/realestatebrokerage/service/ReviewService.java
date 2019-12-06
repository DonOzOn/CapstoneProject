package com.realestatebrokerage.service;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.DistrictRepository;
import com.realestatebrokerage.repository.ProvinceRepository;
import com.realestatebrokerage.repository.ReviewRepository;
import com.realestatebrokerage.repository.WardRepository;
import com.realestatebrokerage.service.dto.ReviewRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final Logger log = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private UserService userService;

    /**
     * List all review
     * **/
    public List<Review> findAll(){
        log.debug("getall");
        return reviewRepository.findAll();
    }


    /**
     * get by id
     * **/
    public Optional<Review> findById(Long id){
        log.debug("find review by id: {} " , id);
        return reviewRepository.findById(id);
    }

    /**
     * get by userID
     * **/
    public List<Review> findByUserId(Long id){
        log.debug("find review by user id : {}", id);
        return reviewRepository.findAllByStatusIsTrueAndUserId(id);
    }

    /**
     * List all review by date
     * **/
    public List<Review> findAllByDate(Instant from, Instant to){
        log.debug("getall by date: {} {}", from , to);
        return reviewRepository.findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(from, to);
    }

    /**
     * update product post
     * */
    public Optional<Review>  updateLiked(Long reviewId, int num) {
        log.debug("run in update post product: {}", reviewId);
        return Optional.of(reviewRepository.findById(reviewId)).filter(Optional::isPresent).map(Optional::get)
            .map(review -> {
                review.setTotalLike(num);
                return reviewRepository.save(review);
            });
    }

    /**
     * create review/question
     * */
    public Review createReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = new Review();
        Optional<User> user = userService.getUserWithAuthorities();
        if(user.isPresent()){
            review.setUser(user.get());
        }
        review.setId(reviewRequestDTO.getId());
        review.setContent(reviewRequestDTO.getContent());
        review.setDecription(reviewRequestDTO.getDecription());
        review.setStatus(true);
        review.setTitle(reviewRequestDTO.getTitle());
        if(reviewRequestDTO.getImageUrl() != null){
            review.setImageUrl(reviewRequestDTO.getImageUrl());
        }
        if(reviewRequestDTO.getWard()!= null){
            Ward ward = wardRepository.findById(reviewRequestDTO.getWard()).orElse(null);
            review.setWard(ward);
        }
        if(reviewRequestDTO.getDistrict()!= null){
            District district = districtRepository.findById(reviewRequestDTO.getDistrict()).orElse(null);
            review.setDistrict(district);
        }
        if(reviewRequestDTO.getProvince()!= null){
            Province province = provinceRepository.findById(reviewRequestDTO.getProvince()).orElse(null);
            review.setProvince(province);
        }
        return reviewRepository.save(review);
    }

    /**
     * upate new
     * */
    public Optional<Review> updateReview(ReviewRequestDTO reviewRequestDTO) {
        return Optional.of(reviewRepository.findById(reviewRequestDTO.getId())).filter(Optional::isPresent).map(Optional::get)
            .map(review -> {
                review.setId(reviewRequestDTO.getId());
                review.setTitle(reviewRequestDTO.getTitle());
                review.setContent(reviewRequestDTO.getContent());
                review.setDecription(reviewRequestDTO.getDecription());
                review.setStatus(true);
                if(reviewRequestDTO.getWard()!= null){
                    Ward ward = wardRepository.findById(reviewRequestDTO.getWard()).orElse(null);
                    review.setWard(ward);
                }
                if(reviewRequestDTO.getDistrict()!= null){
                    District district = districtRepository.findById(reviewRequestDTO.getDistrict()).orElse(null);
                    review.setDistrict(district);
                }
                if(reviewRequestDTO.getProvince()!= null){
                    Province province = provinceRepository.findById(reviewRequestDTO.getProvince()).orElse(null);
                    review.setProvince(province);
                }
                if(reviewRequestDTO.getImageUrl() != null){
                    review.setImageUrl(reviewRequestDTO.getImageUrl());
                }
                review.setStatus(true);
                return reviewRepository.save(review);
            });
    }

    /**
     * upate review interact
     * */
    public Optional<Review> updateReviewInteractive(ReviewRequestDTO reviewRequestDTO) {
        return Optional.of(reviewRepository.findById(reviewRequestDTO.getId())).filter(Optional::isPresent).map(Optional::get)
            .map(review -> {
                review.setTotalLike(reviewRequestDTO.getTotalLike());
                review.setTotalReport(reviewRequestDTO.getTotalReport());
                review.setTotalShare(reviewRequestDTO.getTotalShare());
                return reviewRepository.save(review);
            });
    }

    /**
     * delete review
     * */
    public void deleteReview(Long id) {
         Optional.of(reviewRepository.findById(id)).filter(Optional::isPresent).map(Optional::get)
            .map(review -> {
                review.setStatus(!review.isStatus());
                return reviewRepository.save(review);
            });

    }

}
