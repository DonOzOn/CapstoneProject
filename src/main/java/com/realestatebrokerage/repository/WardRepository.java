package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.District;
import com.realestatebrokerage.domain.Ward;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, String> {

	List<Ward> findAllByDistrictCode(String code);

}
