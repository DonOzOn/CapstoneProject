package com.realestatebrokerage.service;

import com.realestatebrokerage.domain.Ward;
import com.realestatebrokerage.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WardService {
    private final Logger log = LoggerFactory.getLogger(WardService.class);
    @Autowired
    private WardRepository wardRepository;

    public Optional<Ward> findById(String code){
            return  wardRepository.findById(code);
    };
    public List<Ward> findAllByDistrictCode(String districtCode){
        return wardRepository.findAllByDistrictCode(districtCode);
    };
}
