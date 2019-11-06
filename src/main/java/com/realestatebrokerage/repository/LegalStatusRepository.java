package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.LegalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LegalStatusRepository extends JpaRepository<LegalStatus, Long> {
    public List<LegalStatus> findAll();
}
