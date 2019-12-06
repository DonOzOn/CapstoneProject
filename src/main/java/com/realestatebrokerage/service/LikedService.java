package com.realestatebrokerage.service;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikedService {
    private final Logger log = LoggerFactory.getLogger(LikedService.class);

    @Autowired
    private LikedPostRepository likedPostRepository;

    @Autowired
    private LikedReviewRepository likedReviewRepository;

    @Autowired
    private ProductPostRepository productPostRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * create like post
     * */
   public LikedPost checkLikePost(Long userId, Long postId){
       int count = likedPostRepository.countAllByUserIdAndProductPostId(userId, postId);
       if(count <= 0){
           log.debug("count : {}", count);
           return createLiked(userId, postId);
       }else {
           return updateLiked(postId, userId).orElse(null);
       }
   }

    /**
     * create like review
     * */
    public LikedReview checkLikeReview(Long userId, Long reviewId){
        int count = likedReviewRepository.countAllByUserIdAndReviewId(userId, reviewId);
        if(count <= 0){
            log.debug("count : {}", count);
            return createLikedReview(userId, reviewId);
        }else {
            return updateLikedReview(reviewId, userId).orElse(null);
        }
    }

    /**
     * check like post
     * */
    public LikedPost checkLikeStatus(Long postId, Long userId){
        return likedPostRepository.findByProductPostIdAndUserId(postId, userId).orElse(null);
    }

    /**
     * check like review
     * */
    public LikedReview checkLikeStatusReview(Long reviewId, Long userId){
        return likedReviewRepository.findByReviewIdAndUserId(reviewId, userId).orElse(null);
    }

   /**
    * create like post
    * */
    public LikedPost createLiked(Long userId, Long postId) {
        LikedPost likedPost  = new LikedPost();
        ProductPost productPost = productPostRepository.findById(postId).orElse(null);
        likedPost.setProductPost(productPost);
        User user = userRepository.findById(userId).orElse(null);
        likedPost.setUser(user);
        likedPost.setStatus(true);
        return likedPostRepository.save(likedPost);
    }

    /**
     * create like review
     * */
    public LikedReview createLikedReview(Long userId, Long reviewId) {
        LikedReview likedReview  = new LikedReview();
        Review review = reviewRepository.findById(reviewId).orElse(null);
        likedReview.setReview(review);
        User user = userRepository.findById(userId).orElse(null);
        likedReview.setUser(user);
        likedReview.setStatus(true);
        return likedReviewRepository.save(likedReview);
    }

    /**
     * count like post
     * */
    public int countLikePost(Long postId) {
        return likedPostRepository.countAllByProductPostIdAndStatusIsTrue(postId);
    }

    /**
     * count like review
     * */
    public int countLikeReview(Long reviewId) {
        return likedReviewRepository.countAllByReviewIdAndStatusIsTrue(reviewId);
    }

    /**
     * upate post like
     * */
    public Optional<LikedPost> updateLiked(Long postId, Long userId) {
        return Optional.of(likedPostRepository.findByProductPostIdAndUserId(postId, userId)).filter(Optional::isPresent).map(Optional::get)
            .map(likedPost -> {
                likedPost.setStatus(!likedPost.isStatus());
                return likedPostRepository.save(likedPost);
            });
    }

    /**
     * upate post like
     * */
    public Optional<LikedReview> updateLikedReview(Long reviewId, Long userId) {
        return Optional.of(likedReviewRepository.findByReviewIdAndUserId(reviewId, userId)).filter(Optional::isPresent).map(Optional::get)
            .map(likedReview -> {
                likedReview.setStatus(!likedReview.isStatus());
                return likedReviewRepository.save(likedReview);
            });
    }
}
