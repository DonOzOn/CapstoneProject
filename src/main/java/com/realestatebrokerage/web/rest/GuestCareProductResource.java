package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.GuestCareProduct;
import com.realestatebrokerage.domain.News;
import com.realestatebrokerage.service.GuestCareProductService;
import com.realestatebrokerage.service.NewService;
import com.realestatebrokerage.service.dto.GuestCareProductRequestDTO;
import com.realestatebrokerage.service.dto.GuestCareProductResponeDTO;
import com.realestatebrokerage.service.dto.NewsDTO;
import io.github.jhipster.web.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api")
public class GuestCareProductResource {
    private final Logger log = LoggerFactory.getLogger(GuestCareProductResource.class);

    @Autowired
    private GuestCareProductService guestCareProductService;

    @GetMapping("/guest")
    public ResponseEntity<List<GuestCareProductResponeDTO>> getNews() {
        log.debug("get list news : {}");
        return new ResponseEntity<>(guestCareProductService.findAll().stream().map(GuestCareProductResponeDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<GuestCareProductResponeDTO> getGuestCare(@PathVariable("id") Long id) {
        log.debug("get list news by id : {}", id);
        return new ResponseEntity<>(guestCareProductService.findById(id).map(GuestCareProductResponeDTO::new).orElse(null), HttpStatus.OK);
    }
    /**
     * {@code GET /Post} : get all Post.
     *
     */
    @GetMapping("/guest/search-by-date")
    public ResponseEntity<List<GuestCareProductResponeDTO>> getAllNewByDate(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to) throws ParseException
    {
        Date fromDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(from);
        Instant fromIns = fromDate.toInstant();
        Date toDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(to);
        Instant toIns = toDate.toInstant();
        List<GuestCareProductResponeDTO> postList =  guestCareProductService.findAllByDate(fromIns , toIns).stream()
            .map(GuestCareProductResponeDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    /**
     * new
     * */
    @PostMapping("/guest")
    public ResponseEntity<GuestCareProduct> createProduct(@RequestBody GuestCareProductRequestDTO guestCareProductRequestDTO)
    {
        log.debug("create  guest: {}", guestCareProductRequestDTO);
        GuestCareProduct guestCareProduct = guestCareProductService.createGuestCareProduct(guestCareProductRequestDTO);
        return new ResponseEntity<>(guestCareProduct, HttpStatus.OK);
    }
    /**
     * {@code PUT /guest} : Updates an existing Guest.
     *
     * @param guestCareProductRequestDTO the GuestCare to update.
     */
    @PutMapping("/guest")
    public ResponseEntity<Optional<GuestCareProductResponeDTO>> updateNews(@RequestBody GuestCareProductRequestDTO guestCareProductRequestDTO) {
        log.debug("REST request to update News : {}", guestCareProductRequestDTO);
        Optional<GuestCareProductResponeDTO> updateGuest = guestCareProductService.updateGuestCare(guestCareProductRequestDTO).map(GuestCareProductResponeDTO::new);
        return new ResponseEntity<>(updateGuest, HttpStatus.OK);
    }

    /**
     * {@code Delete /guest} : delete an existing GuestCare.
     *
     * @param id the GuestCare to delete.
     */
    @DeleteMapping("/guest/{id}")
    public ResponseEntity<Optional<GuestCareProductResponeDTO>> deleteNews(@PathVariable("id") Long id) {
        log.debug("REST request to update News : {}", id);
        Optional<GuestCareProductResponeDTO> deleteGuest = guestCareProductService.deleteGuest(id).map(GuestCareProductResponeDTO::new);
        return new ResponseEntity<>(deleteGuest, HttpStatus.OK);
    }
    /**
     * {@code GET /users} : get all guest.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body all users.
     */
    @GetMapping("/guest/getAllGuest")
    public ResponseEntity<List<GuestCareProductResponeDTO>> getAllGuest(Long userid, Pageable pageable) {
        log.debug("id: {}", userid );
        final Page<GuestCareProductResponeDTO> page = guestCareProductService.getAllGuest(userid, pageable).map(GuestCareProductResponeDTO::new);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }



}
