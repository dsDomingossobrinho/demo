package com.afrikancoders.typeNotification.service;

import java.util.List;

import com.afrikancoders.typeNotification.dto.TypeNotificationDto;
import com.afrikancoders.typeNotification.entity.TypeNotifications;
import com.afrikancoders.typeNotification.response.TypeNotificationResponse;

public interface TypeNotificationService {

    TypeNotificationResponse saveTypeNotification(TypeNotificationDto typeNotificationDto);

    TypeNotificationResponse updateTypeNotification(Long id, TypeNotificationDto typeNotificationDto);

    void deleteTypeNotification(Long id);    

    List<TypeNotificationResponse> getAllTypeNotifications();

    TypeNotifications getTypeNotificationById(Long id);

    TypeNotificationResponse getTypeNotificationByIdResponse(Long id);

    TypeNotifications getTypeNotificationByTypeNotification(String typeNotification);
    
}
