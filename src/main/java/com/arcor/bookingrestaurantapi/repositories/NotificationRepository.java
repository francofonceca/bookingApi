package com.arcor.bookingrestaurantapi.repositories;

import java.util.Optional;

import com.arcor.bookingrestaurantapi.entities.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    Optional<Notification> findByTemplateCode(String templateCode);
}
