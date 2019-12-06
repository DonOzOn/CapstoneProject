package com.realestatebrokerage.service;
import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.repository.LikedPostRepository;
import com.realestatebrokerage.repository.LikedReviewRepository;
import com.realestatebrokerage.repository.NewRepository;
import com.realestatebrokerage.service.dto.NewsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class LikedService {
    private final Logger log = LoggerFactory.getLogger(LikedService.class);

    @Autowired
    private LikedPostRepository likedPostRepository;

    @Autowired
    private LikedReviewRepository likedReviewRepository;


}
