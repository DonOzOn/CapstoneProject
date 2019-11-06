package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Utilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilitiesRepository extends JpaRepository<Utilities, String> {
    public List<Utilities> findAll();
}
