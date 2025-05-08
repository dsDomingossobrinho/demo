package com.afrikancoders.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.notification.entity.Notifications;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {
    
}
