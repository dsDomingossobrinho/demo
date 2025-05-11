package com.afrikancoders.typeNotification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afrikancoders.typeNotification.dto.TypeNotificationDto;
import com.afrikancoders.typeNotification.entity.TypeNotifications;
import com.afrikancoders.typeNotification.repository.TypeNotificationRepository;
import com.afrikancoders.typeNotification.response.TypeNotificationResponse;
import com.afrikancoders.state.service.StatusService;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeNotificationServiceImpl implements TypeNotificationService {

    private final TypeNotificationRepository typeNotificationRepository;

    private final StatusService statusService;

    /*@PostConstruct
    public void migration() {
        if (typeNotificationRepository.count() == 0) {
            String[] array = {
                "ADMIN",
                "SECRETARY",
                "FURNISHER",
                "DISTRIBUTOR",
                "COLLABORATOR",
                "COMPANY"
            };

            for (int i = 0; i < array.length; i++) {
                TypeNotifications typeNotification = new TypeNotifications();
                typeNotification.setType(array[i]);
                typeNotificationRepository.save(typeNotification);
            }
        }
    }*/

    @Override
    public TypeNotificationResponse saveTypeNotification(TypeNotificationDto typeNotificationDto) {
        TypeNotifications typeNotification = new TypeNotifications();
        typeNotification.setType(typeNotificationDto.type());
        typeNotification.setState(statusService.getStateById(1L));
        typeNotificationRepository.save(typeNotification);
        return new TypeNotificationResponse(typeNotification.getId(),typeNotification.getType());
    }

    @Override
    public TypeNotificationResponse updateTypeNotification(Long id, TypeNotificationDto typeNotificationDto) {
        TypeNotifications typeNotification = this.getTypeNotificationById(id);
        typeNotification.setType(typeNotificationDto.type());
        typeNotificationRepository.save(typeNotification);
        return new TypeNotificationResponse(typeNotification.getId(), typeNotification.getType());
    }

    @Override
    public List<TypeNotificationResponse> getAllTypeNotifications() {
        return typeNotificationRepository.findAllResponse();
    }

    @Override
    public TypeNotifications getTypeNotificationById(Long id) {
        return typeNotificationRepository.findByIdAndStateId(id, 1L)
            .orElseThrow(() -> new EntityNotFoundException("TypeNotifications with ID " + id + " not found."));
    }

    @Override
    public TypeNotifications getTypeNotificationByTypeNotification(String typeNotification) {
        return typeNotificationRepository.findByType(typeNotification)
        .orElseThrow(() -> new EntityNotFoundException("TypeNotifications " + typeNotification + " not found."));
    }

    @Override
    public TypeNotificationResponse getTypeNotificationByIdResponse(Long id) {
        TypeNotifications typeNotification = this.getTypeNotificationById(id);
        return new TypeNotificationResponse(typeNotification.getId(), typeNotification.getType());
    }

    
    @Override
    public void deleteTypeNotification(Long id) {
        TypeNotifications typeNotification = this.getTypeNotificationById(id);
        typeNotification.setState(statusService.getStateById(3L));
        typeNotificationRepository.save(typeNotification);
    }
    
}
