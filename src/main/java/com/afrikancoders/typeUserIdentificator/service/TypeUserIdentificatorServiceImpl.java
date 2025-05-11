package com.afrikancoders.typeUserIdentificator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afrikancoders.typeUserIdentificator.dto.TypeUserIdentificatorDto;
import com.afrikancoders.typeUserIdentificator.entity.TypeUserIdentificators;
import com.afrikancoders.typeUserIdentificator.repository.TypeUserIdentificatorRepository;
import com.afrikancoders.typeUserIdentificator.response.TypeUserIdentificatorResponse;
import com.afrikancoders.state.service.StatusService;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeUserIdentificatorServiceImpl implements TypeUserIdentificatorService {

    private final TypeUserIdentificatorRepository typeUserIdentificatorRepository;

    private final StatusService statusService;

    @PostConstruct
    public void migration() {
        if (typeUserIdentificatorRepository.count() == 0) {
            String[] array = {
                "ADMIN",
                "SECRETARY",
                "FURNISHER",
                "DISTRIBUTOR",
                "COLLABORATOR",
                "COMPANY"
            };

            for (int i = 0; i < array.length; i++) {
                TypeUserIdentificators typeUserIdentificator = new TypeUserIdentificators();
                typeUserIdentificator.setType(array[i]);
                typeUserIdentificatorRepository.save(typeUserIdentificator);
            }
        }
    }

    @Override
    public TypeUserIdentificatorResponse saveTypeUserIdentificator(TypeUserIdentificatorDto TypeUserIdentificatorDto) {
        TypeUserIdentificators typeUserIdentificator = new TypeUserIdentificators();
        typeUserIdentificator.setType(TypeUserIdentificatorDto.type());
        typeUserIdentificator.setState(statusService.getStateById(1L));
        typeUserIdentificatorRepository.save(typeUserIdentificator);
        return new TypeUserIdentificatorResponse(typeUserIdentificator.getId(),typeUserIdentificator.getType());
    }

    @Override
    public TypeUserIdentificatorResponse updateTypeUserIdentificator(Long id, TypeUserIdentificatorDto TypeUserIdentificatorDto) {
        TypeUserIdentificators typeUserIdentificator = this.getTypeUserIdentificatorById(id);
        typeUserIdentificator.setType(TypeUserIdentificatorDto.type());
        typeUserIdentificatorRepository.save(typeUserIdentificator);
        return new TypeUserIdentificatorResponse(typeUserIdentificator.getId(), typeUserIdentificator.getType());
    }

    @Override
    public List<TypeUserIdentificatorResponse> getAllTypeUserIdentificators() {
        return typeUserIdentificatorRepository.findAllResponse();
    }

    @Override
    public TypeUserIdentificators getTypeUserIdentificatorById(Long id) {
        return typeUserIdentificatorRepository.findByIdAndStateId(id, 1L)
            .orElseThrow(() -> new EntityNotFoundException("TypeUserIdentificators with ID " + id + " not found."));
    }

    @Override
    public TypeUserIdentificators getTypeUserIdentificatorByTypeUserIdentificator(String TypeUserIdentificator) {
        return typeUserIdentificatorRepository.findByType(TypeUserIdentificator)
        .orElseThrow(() -> new EntityNotFoundException("TypeUserIdentificators " + TypeUserIdentificator + " not found."));
    }

    @Override
    public TypeUserIdentificatorResponse getTypeUserIdentificatorByIdResponse(Long id) {
        TypeUserIdentificators typeUserIdentificator = this.getTypeUserIdentificatorById(id);
        return new TypeUserIdentificatorResponse(typeUserIdentificator.getId(), typeUserIdentificator.getType());
    }

    
    @Override
    public void deleteTypeUserIdentificator(Long id) {
        TypeUserIdentificators typeUserIdentificator = this.getTypeUserIdentificatorById(id);
        typeUserIdentificator.setState(statusService.getStateById(3L));
        typeUserIdentificatorRepository.save(typeUserIdentificator);
    }
    
}
