package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, String> {
    public List<Province> findAll();
}
