package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.UsingUtilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsingUtilitiesRepository extends JpaRepository<UsingUtilities, String> {
    public List<UsingUtilities> findAll();
}
