package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductPost;
import com.realestatebrokerage.domain.ProductPostType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductPostRepository extends JpaRepository<ProductPost, Long> {
    public List<ProductPost> findAll();
//    Page<ProductPost> findAll(Pageable pageable);
//    Page<ProductPost> findByCreatedDate(Instant createdDate, Pageable pageable);
//    Page<ProductPost> findByPrice(String price, Pageable pageable);

    @Query(value = "SELECT pp FROM ProductPost pp where 1=1")
    Page<ProductPost> filter(Pageable pageable);
    public List<ProductPost> findAllByStatusTrue();

    public List<ProductPost> findAllByStatusIsTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Instant from, Instant to);


    public List<ProductPost> findAllByUserId(Long id);

    @Query(value = "SELECT pp FROM ProductPost pp where pp.status = true AND pp.productPostType.id = :postType")
    public List<ProductPost> findAllByProductPostType(@Param("postType")Long postType);

    @Query(value = "SELECT pp FROM ProductPost pp where pp.status = true AND pp.province.code = :province")
    public List<ProductPost> findAllByProvince(@Param("province")String province);

    public Optional<ProductPost> findAllByStatusTrueAndProductIdAndProductPostTypeId(Long id, Long postTypeID);

}
