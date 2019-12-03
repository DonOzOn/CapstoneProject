package com.realestatebrokerage.repository;

import com.realestatebrokerage.domain.GuestCareProduct;
import com.realestatebrokerage.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    public List<Notification> findAllByStatusIsTrue();

    public List<Notification> findAllByStatusTrueAndCreatedDateGreaterThanEqualAndCreatedDateLessThanEqual(Instant from, Instant to);

}
