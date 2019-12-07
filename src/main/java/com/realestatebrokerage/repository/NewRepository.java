package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.LegalStatus;
import com.realestatebrokerage.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface NewRepository extends JpaRepository<News, Long> {


    public List<News> findAllByStatusIsTrue();

    public List<News> findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Instant from, Instant to);



//    public List<News> findAllNewsNew(int limit);


}
