package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.District;
import com.realestatebrokerage.repository.DistrictRepository;
import com.realestatebrokerage.repository.WardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    private final Logger log = LoggerFactory.getLogger(WardService.class);
    @Autowired
    private DistrictRepository districtRepository;

    public List<District>  findAllByProvinceCode(String code){
        return districtRepository.findAllByProvinceCode(code);
    }
}
