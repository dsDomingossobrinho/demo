package com.afrikancoders.typeNotification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.typeNotification.entity.TypeNotifications;

public interface TypeNotificationRepository extends JpaRepository<TypeNotifications, Long> {
    
}
