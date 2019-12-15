package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.ProductPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
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


    public List<ProductPost> findAllByUserIdAndStatusIsTrue(Long id);

    @Query(value = "SELECT pp FROM ProductPost pp where pp.status = true AND pp.productPostType.id = :postType")
    public List<ProductPost> findAllByProductPostType(@Param("postType")Long postType);

    @Query(value = "SELECT pp FROM ProductPost pp where pp.status = true AND pp.province.code = :province")
    public List<ProductPost> findAllByProvince(@Param("province")String province);

    public Optional<ProductPost> findAllByStatusTrueAndProductIdAndProductPostTypeId(Long id, Long postTypeID);

    @Query(value = "SELECT pp FROM ProductPost pp WHERE" +
        "(:province IS NULL OR pp.province.code = :province) " +
        "AND (:district IS NULL OR pp.district.code = :district)"
        +"AND (:ward IS NULL OR pp.ward.code = :ward)"
        +"AND (:postType IS NULL OR pp.productPostType.id = :postType)"
        +"AND (:priceFrom IS NULL OR pp.product.price >= :priceFrom)"
        +"AND (:priceTo IS NULL OR pp.product.price < :priceTo)"
        +"AND (:areaFrom IS NULL OR pp.product.area >= :areaFrom )"
        +"AND (:areaTo IS NULL OR pp.product.area < :areaTo)"
        +"AND (:direction IS NULL OR pp.product.direction.id = :direction)"
        +"AND (:numBathroom IS NULL OR (pp.product.numberBathroom = :numBathroom))"
        +"AND (:numBedroom IS NULL OR (pp.product.numberBedroom = :numBedroom))")
    public Page<ProductPost> filterByAllCharracter(@Param("province") String province,
                                                    @Param("district")String district,
                                                    @Param("ward") String ward,
                                                    @Param("postType") Long postType,
                                                    @Param("priceFrom") Long priceFrom,
                                                    @Param("priceTo") Long priceTo,
                                                    @Param("areaFrom") Long areaFrom,
                                                    @Param("areaTo") Long areaTo,
                                                    @Param("direction") Long direction,
                                                    @Param("numBathroom") Integer numBathroom,
                                                    @Param("numBedroom") Integer numBedroom,
                                                   Pageable pageable );

    /**
     * - 8 7 5 2
     * - 4,3,1,6
     * */
    @Query(value = "SELECT pp FROM ProductPost pp where " +
        "pp.product.direction.id = 8 "
        +"OR pp.product.direction.id = 7"
        +"OR pp.product.direction.id = 5"
        +"OR pp.product.direction.id = 2" )
    public List<ProductPost> findAllByDirectionHouseOneToFour();

    @Query(value = "SELECT pp FROM ProductPost pp where " +
        "pp.product.direction.id = 4 "
        +"OR pp.product.direction.id = 3"
        +"OR pp.product.direction.id = 1"
        +"OR pp.product.direction.id = 6" )
    public List<ProductPost> findAllByDirectionHouseFiveToEight();


}
