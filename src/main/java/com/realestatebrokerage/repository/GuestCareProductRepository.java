package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.GuestCareProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface GuestCareProductRepository extends JpaRepository<GuestCareProduct, Long> {

    public List<GuestCareProduct> findAllByStatusIsTrue();

    public List<GuestCareProduct> findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Instant from, Instant to);

    @Query("SELECT DISTINCT g from GuestCareProduct g"
        + "  WHERE (g.status = true)")
    Page<GuestCareProduct> findAllGuest(Pageable pageable);
}
