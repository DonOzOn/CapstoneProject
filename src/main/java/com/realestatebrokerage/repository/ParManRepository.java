package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ParMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParManRepository extends JpaRepository<ParMan, Long> {
    List<ParMan> findAll();
}
