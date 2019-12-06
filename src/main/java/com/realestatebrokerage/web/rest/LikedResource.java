package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.LikedPost;
import com.realestatebrokerage.domain.LikedReview;
import com.realestatebrokerage.service.LikedService;
import com.realestatebrokerage.service.ProductPostService;
import com.realestatebrokerage.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class LikedResource {
    private final Logger log = LoggerFactory.getLogger(LikedResource.class);

    @Autowired
    private LikedService likedService;

    @Autowired
    private ProductPostService productPostService;

    @Autowired
    private ReviewService reviewService;
    /**
     * count liked post
     * */
    @GetMapping("/liked-post")
    public ResponseEntity<LikedPost> getLikedPost(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId ) {
        log.debug("get likedPost : {}");
        LikedPost likedPost = likedService.checkLikePost(userId, postId);
        int count = likedService.countLikePost(postId);
        productPostService.updateLiked(postId, count);
        return new ResponseEntity<>(likedPost, HttpStatus.OK);
    }

    /**
     * count liked review
     * */
    @GetMapping("/liked-review")
    public ResponseEntity<LikedReview> getLikedReview(@RequestParam("userId") Long userId, @RequestParam("reviewId") Long reviewId ) {
        log.debug("get likedReview : {}");
        LikedReview likedReview = likedService.checkLikeReview(userId, reviewId);
        int count = likedService.countLikeReview(reviewId);
        reviewService.updateLiked(reviewId, count);
        return new ResponseEntity<>(likedReview, HttpStatus.OK);
    }

    /**
     * check liked post
     * */
    @GetMapping("/liked-post/checkstatus")
    public ResponseEntity<LikedPost> checkStatusPost(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId ) {
        log.debug("check status : {}");
        return new ResponseEntity<>(likedService.checkLikeStatus(postId, userId), HttpStatus.OK);
    }

    /**
     * check liked review
     * */
    @GetMapping("/liked-review/checkstatus")
    public ResponseEntity<LikedReview> checkStatusReview(@RequestParam("userId") Long userId, @RequestParam("reviewId") Long reviewId ) {
        log.debug("check status : {}");
        return new ResponseEntity<>(likedService.checkLikeStatusReview(reviewId, userId), HttpStatus.OK);
    }

    /**
     * count liked post
     * */
    @GetMapping("/liked-post/{postId}")
    public ResponseEntity<Integer> getTotalLikePost(@PathVariable("postId") Long postId) {
        log.debug("get all likedPost : {}");
        int totalLike = likedService.countLikePost(postId);
        return new ResponseEntity<>(totalLike, HttpStatus.OK);
    }

}
