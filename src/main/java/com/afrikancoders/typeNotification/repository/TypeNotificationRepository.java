package com.afrikancoders.typeNotification.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afrikancoders.typeNotification.entity.TypeNotifications;
import com.afrikancoders.typeNotification.response.TypeNotificationResponse;

public interface TypeNotificationRepository extends JpaRepository<TypeNotifications, Long> {
    Optional<TypeNotifications> findById(Long id);

    Optional<TypeNotifications> findByType(String TypeNotification);

    Optional<TypeNotifications> findByIdAndStateId(Long id, Long stateId);

    Optional<TypeNotifications> findByTypeAndStateId(String Type, Long stateId);

    List<TypeNotifications> findAll();

    @Query("SELECT new com.afrikancoders.typeNotification.response.TypeNotificationResponse(t.id, t.type) FROM TypeNotifications t WHERE t.state.id = 1")
    List<TypeNotificationResponse> findAllResponse();
}
