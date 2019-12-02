package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ParMan;
import com.realestatebrokerage.domain.ParWoman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParWomanRepository extends JpaRepository<ParWoman, Long> {
    List<ParWoman> findAll();
}
