package com.afrikancoders.typeUserIdentificator.service;

import java.util.List;

import com.afrikancoders.typeUserIdentificator.dto.TypeUserIdentificatorDto;
import com.afrikancoders.typeUserIdentificator.entity.TypeUserIdentificators;
import com.afrikancoders.typeUserIdentificator.response.TypeUserIdentificatorResponse;

public interface TypeUserIdentificatorService {

    TypeUserIdentificatorResponse saveTypeUserIdentificator(TypeUserIdentificatorDto typeUserIdentificatorDto);

    TypeUserIdentificatorResponse updateTypeUserIdentificator(Long id, TypeUserIdentificatorDto typeUserIdentificatorDto);

    void deleteTypeUserIdentificator(Long id);    

    List<TypeUserIdentificatorResponse> getAllTypeUserIdentificators();

    TypeUserIdentificators getTypeUserIdentificatorById(Long id);

    TypeUserIdentificatorResponse getTypeUserIdentificatorByIdResponse(Long id);

    TypeUserIdentificators getTypeUserIdentificatorByTypeUserIdentificator(String typeUserIdentificator);
    
}
