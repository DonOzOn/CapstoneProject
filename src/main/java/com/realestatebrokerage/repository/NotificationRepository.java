package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.GuestCareProduct;
import com.realestatebrokerage.domain.Notification;
import com.realestatebrokerage.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    public List<Notification> findAllByStatusIsTrue();

    public List<Notification> findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Instant from, Instant to);




    @Query(value = "SELECT n FROM Notification n where n.userReceive.id = :userid "+"ORDER BY n.status desc ,n.createdDate desc")
    Page<Notification> findByUser(@Param("userid") Long userid, Pageable pageable);

    @Query(value = "SELECT n FROM Notification n where n.userReceive.id = :userid AND n.status = true "+"ORDER BY n.status desc ,n.createdDate desc")
    Page<Notification> findByUserStatusTrue(@Param("userid") Long userid, Pageable pageable);
}
