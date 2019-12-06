package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.DirectionHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectionHouseRepository extends JpaRepository<DirectionHouse, Long> {
    List<DirectionHouse> findAll();

    @Query("SELECT a FROM DirectionHouse a where a.name_par like CONCAT('%', CONVERT(:parName, BINARY), '%')")
    Optional<DirectionHouse> findByParName(@Param("parName") String parName);
}
