package com.realestatebrokerage.service;
import com.realestatebrokerage.domain.News;
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
public class NewService {
    private final Logger log = LoggerFactory.getLogger(NewService.class);

    @Autowired
    private NewRepository newRepository;


    /**
     * List all product
     * **/
    public List<News> findAll(){
        log.debug("getall");
        return newRepository.findAll();
    }


    /**
     * get by id
     * **/
    public Optional<News> findById(Long id){
        log.debug("find by id");
        return newRepository.findById(id);
    }
    /**
     * List all news by date
     * **/
    public List<News> findAllByDate(Instant from, Instant to){
        log.debug("getall by date: {} {}", from , to);
        return newRepository.findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(from, to);
    }


    /**
     * create new
     * */
    public News createNews(NewsDTO newDTO) {
        News news = new News();
        news.setId(newDTO.getId());
        news.setContent(newDTO.getContent());
        news.setDecription(newDTO.getDecription());
        news.setStatus(true);
        news.setTitle(newDTO.getTitle());
        news.setImageUrl(newDTO.getImageUrl());
        return newRepository.save(news);
    }

    /**
     * upate new
     * */
    public Optional<News> updateNews(NewsDTO newDTO) {
        return Optional.of(newRepository.findById(newDTO.getId())).filter(Optional::isPresent).map(Optional::get)
            .map(news -> {
                news.setTitle(newDTO.getTitle());
                news.setDecription(newDTO.getDecription());
                news.setContent(newDTO.getContent());
                if(newDTO.getImageUrl() != null){
                    news.setImageUrl(newDTO.getImageUrl());
                }
                news.setStatus(true);
                return newRepository.save(news);
            });
    }
    /**
     * delete new
     * */
    public void deleteNews(Long id) {
         Optional.of(newRepository.findById(id)).filter(Optional::isPresent).map(Optional::get)
            .map(news -> {
                news.setStatus(!news.getStatus());
                return newRepository.save(news);
            });

    }

}
