package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.Province;
import com.realestatebrokerage.repository.DistrictRepository;
import com.realestatebrokerage.repository.ProvinceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProvinceService {
    private final Logger log = LoggerFactory.getLogger(ProvinceService.class);

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<Province> findAll(){
        return provinceRepository.findAll();
    }
}
