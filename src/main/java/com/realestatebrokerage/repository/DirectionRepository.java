package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
    public List<Direction> findAll();

}
