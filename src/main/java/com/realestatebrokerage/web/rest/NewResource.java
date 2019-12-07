package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.service.NewService;
import com.realestatebrokerage.service.dto.NewsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class NewResource {
    private final Logger log = LoggerFactory.getLogger(NewResource.class);

    @Autowired
    private NewService newService;

//    @GetMapping("/news")
//    public ResponseEntity<List<NewsDTO>> getNewsNew() {
//        log.debug("get list news : {}");
//        return new ResponseEntity<>(newService.findNewNews(8).stream().map(NewsDTO::new).collect(Collectors.toList()), HttpStatus.OK);
//    }

    @GetMapping("/news")
    public ResponseEntity<List<NewsDTO>> getNews() {
        log.debug("get list news : {}");
        return new ResponseEntity<>(newService.findAll().stream().map(NewsDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<NewsDTO> getNews(@PathVariable("id") Long id) {
        log.debug("get list news by id : {}", id);
        return new ResponseEntity<>(newService.findById(id).map(NewsDTO::new).orElse(null), HttpStatus.OK);
    }
 
    /**
     * {@code GET /Post} : get all Post.
     *
     */
    @GetMapping("/news/search-by-date")
    public ResponseEntity<List<NewsDTO>> getAllNewByDate(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to) throws ParseException
    {
        Date fromDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(from);
        Instant fromIns = fromDate.toInstant();
        Date toDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(to);
        Instant toIns = toDate.toInstant();
        List<NewsDTO> postList =  newService.findAllByDate(fromIns , toIns).stream()
            .map(NewsDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    /**
     * new
     * */
    @PostMapping("/news")
    public ResponseEntity<News> createProduct(@RequestBody NewsDTO newsDTO)
    {
        log.debug("create  news: {}", newsDTO);
        News news = newService.createNews(newsDTO);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
    /**
     * {@code PUT /news} : Updates an existing News.
     *
     * @param newsDTO the user to update.
     */
    @PutMapping("/news")
    public ResponseEntity<Optional<NewsDTO>> updateNews(@RequestBody NewsDTO newsDTO) {
        log.debug("REST request to update News : {}", newsDTO);
        Optional<NewsDTO> updatedUser = newService.updateNews(newsDTO).map(NewsDTO::new);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * {@code PUT /news} : delete an existing News.
     *
     * @param id the news to delete.
     */
    @DeleteMapping("/news/{id}")
    public ResponseEntity<Optional<NewsDTO>> deleteNews(@PathVariable Long id) {
        log.debug("REST request to delete News : {}", id);
        newService.deleteNews(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
