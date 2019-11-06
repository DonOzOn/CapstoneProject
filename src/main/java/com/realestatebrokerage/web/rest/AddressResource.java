package com.realestatebrokerage.web.rest;

import com.realestatebrokerage.domain.District;
import com.realestatebrokerage.domain.Province;
import com.realestatebrokerage.domain.Ward;
import com.realestatebrokerage.service.DistrictService;
import com.realestatebrokerage.service.ProvinceService;
import com.realestatebrokerage.service.WardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api")
public class AddressResource {
    private final Logger log = LoggerFactory.getLogger(AddressResource.class);

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private WardService wardService;

    @GetMapping("/provinces")
    public ResponseEntity<List<Province>> getProvince() {
        log.debug("get list province : {}");
        return new ResponseEntity<>(provinceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/districts")
    public ResponseEntity<List<District>> getDistrict(String provinceCode) {
        log.debug("get list district by province code: {}",provinceCode);
        return new ResponseEntity<>(districtService.findAllByProvinceCode(provinceCode), HttpStatus.OK);
    }

    @GetMapping("/wards")
    public ResponseEntity<List<Ward>> getWard(String districtCode) {
        log.debug("get list wards by district code: {}",districtCode);
        return new ResponseEntity<>(wardService.findAllByDistrictCode(districtCode), HttpStatus.OK);
    }
}
