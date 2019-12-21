package com.realestatebrokerage.web.rest;


import com.realestatebrokerage.domain.Review;
import com.realestatebrokerage.service.HibernateSearchService;
import com.realestatebrokerage.service.ReviewService;
import com.realestatebrokerage.service.dto.ReviewRequestDTO;
import com.realestatebrokerage.service.dto.ReviewResponeDTO;
import io.github.jhipster.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class ReviewResource {
    private final Logger log = LoggerFactory.getLogger(ReviewResource.class);

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private HibernateSearchService hibernateSearchService;

    @GetMapping("/review")
    public ResponseEntity<List<ReviewResponeDTO>> getReviewNews(Pageable pageable) {
        log.debug("get list review : {}");
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdDate").descending() );
        Page<ReviewResponeDTO> reviewList = reviewService.findAll(pageable).map(ReviewResponeDTO::new);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), reviewList);
        return new ResponseEntity<>(reviewList.getContent(),headers , HttpStatus.OK);
    }

    /**
     * {@code GET /Post} : get all Post by UserID.
     *
     */
    @GetMapping("/review/user")
    public ResponseEntity<List<ReviewResponeDTO>> getAllReviewByUserID(Long id, Pageable pageable) {
        log.debug("get by user id : {}", id);
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("createdDate").descending() );
        Page<ReviewResponeDTO> reviewList = reviewService.findByUserId(id, pageable).map(ReviewResponeDTO::new);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), reviewList);
        return new ResponseEntity<>(reviewList.getContent(), headers, HttpStatus.OK);
    }



    @GetMapping("/review/{id}")
    public ResponseEntity<ReviewResponeDTO> getReviewByID(@PathVariable("id") Long id) {
        log.debug("get list review by id : {}", id);
        return new ResponseEntity<>(reviewService.findById(id).map(ReviewResponeDTO::new).orElse(null), HttpStatus.OK);
    }

    /**
     * {@code GET /Post} : get all review by date
     *
     */
    @GetMapping("/review/search-by-date")
    public ResponseEntity<List<ReviewResponeDTO>> getAllNewByDate(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to) throws ParseException
    {
        Date fromDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(from);
        Instant fromIns = fromDate.toInstant();
        Date toDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(to);
        Instant toIns = toDate.toInstant();
        List<ReviewResponeDTO> postList =  reviewService.findAllByDate(fromIns , toIns).stream()
            .map(ReviewResponeDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    /**
     * new
     * */
    @PostMapping("/review")
    public ResponseEntity<Review> createProduct(@RequestBody ReviewRequestDTO reviewRequestDTO)
    {
        log.debug("create  review: {}", reviewRequestDTO);
        Review news = reviewService.createReview(reviewRequestDTO);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    /**
     * {@code PUT /news} : Updates an existing review.
     *
     * @param reviewRequestDTO the user to update.
     */
    @PutMapping("/review")
    public ResponseEntity<Optional<ReviewResponeDTO>> updateNews(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        log.debug("REST request to update Review : {}", reviewRequestDTO);
        Optional<ReviewResponeDTO> updatedUser = reviewService.updateReview(reviewRequestDTO).map(ReviewResponeDTO::new);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * {@code Delete /review} : delete an existing review.
     *
     * @param id the review to delete.
     */
    @DeleteMapping("/review/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        log.debug("REST request to update Review : {}", id);
       reviewService.deleteReview(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * {@code GET /Post} : full text.
     *
     */
    @GetMapping("/review/search")
    public ResponseEntity<List<ReviewResponeDTO>> fullTextSearchReview(@RequestParam(value = "searchKey") String searchKey) throws InterruptedException {
        List<ReviewResponeDTO> reviewResponeDTOS = new ArrayList<>();
        reviewResponeDTOS = hibernateSearchService.fuzzySearchReview(searchKey).stream().map(ReviewResponeDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(reviewResponeDTOS, HttpStatus.OK);
    }
}
