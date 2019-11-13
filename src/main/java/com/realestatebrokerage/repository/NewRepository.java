package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.LegalStatus;
import com.realestatebrokerage.domain.New;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepository extends JpaRepository<New, Long> {
    public List<New> findAll();
}
