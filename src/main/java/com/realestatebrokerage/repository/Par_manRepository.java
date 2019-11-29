package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Direction;
import com.realestatebrokerage.domain.par_man;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Par_manRepository extends JpaRepository<par_man, Long> {
    
}
