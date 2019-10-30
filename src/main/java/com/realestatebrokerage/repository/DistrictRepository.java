package com.realestatebrokerage.repository;
import com.realestatebrokerage.domain.District;
import com.realestatebrokerage.domain.Province;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, String> {

	List<District> findAllByProvinceCode(String province);

}
