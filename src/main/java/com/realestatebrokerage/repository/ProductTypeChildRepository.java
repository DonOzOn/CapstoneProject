package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.District;
import com.realestatebrokerage.domain.ProductTypeChild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeChildRepository extends JpaRepository<ProductTypeChild, String> {

	List<ProductTypeChild> findAllByProductType_Id(Long productType);

}
